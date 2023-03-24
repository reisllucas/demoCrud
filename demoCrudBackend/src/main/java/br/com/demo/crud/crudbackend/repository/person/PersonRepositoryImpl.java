package br.com.demo.crud.crudbackend.repository.person;

import br.com.demo.crud.crudbackend.domain.model.Person;
import br.com.demo.crud.crudbackend.utils.Utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepositoryCustom{

    @PersistenceContext()
    private EntityManager entityManager;

    /**
     * handle a List of persons
     * @param search search parameter
     * @see br.com.demo.crud.crudbackend.domain.model.Person
     * @return a List of Person
     */
    @Override
    public List<Person> findAll(String search) {

        CriteriaBuilder cb = entityManager
                .getCriteriaBuilder();

        CriteriaQuery<Person> criteriaQuery = cb
                .createQuery(Person.class);

        Root<Person> from = criteriaQuery.from(Person.class);

        CriteriaQuery<Person> select;
        if (search != null && !search.isEmpty()) {
            select = criteriaQuery
                    .select(from)
                    .where(cb.or(
                                    findPredicates(cb,
                                            search != null ? search.toUpperCase().trim() : null,
                                            from)
                            )
                    )
                    .orderBy( findOrders(cb, from));
        } else {
            select = criteriaQuery
                    .select(from)

                    .orderBy( findOrders(cb, from));
        }


        TypedQuery<Person> typedQuery = entityManager.createQuery(select);

        return typedQuery.getResultList();

    }

    /**
     * Creates the where clause
     * @param cb CriteriaQuery
     * @param search search parameter
     * @param from Root
     * @return an array of Predicate
     */
    private Predicate[] findPredicates(CriteriaBuilder cb, String search, Root<Person> from) {

        List<Predicate> predicates = new ArrayList<>();

        if (search != null && !search.trim().isEmpty()) {
            predicates.add(cb.like(cb.upper(from.get("name")), strLike(search)));
            predicates.add(cb.like(cb.upper(from.get("phone")), strLike(search)));
            predicates.add(cb.like(cb.upper(from.get("zipCode")), strLike(search)));
            predicates.add(cb.like(cb.upper(from.get("address")), strLike(search)));
            predicates.add(cb.like(cb.upper(from.get("email")), strLike(search)));
            predicates.add(cb.like(cb.upper(from.get("city")), strLike(search)));
            predicates.add(cb.like(cb.upper(from.get("state")), strLike(search)));

            if (Utils.isNumeric(search))
                predicates.add(cb.equal(from.get("id"), Long.valueOf(search)));

            Utils.isCountry(search)
                    .ifPresent(
                            country -> predicates.add(cb.equal(from.get("country"), country))
                    );

        }

        Predicate[] preds = new Predicate[predicates.size()];
        predicates.toArray(preds);

        return  preds;

    }


    /**
     * Creates the Order by clause
     * @param cb CriteriaQuery
     * @param from Root
     * @return an array of Order
     */
    private List<Order> findOrders(CriteriaBuilder cb, Root<Person> from) {

        return Arrays.asList(cb.desc(from.get("id")));

    }


    private String strLike(String str) {
        return "%" + str.toUpperCase() + "%";
    }


}
