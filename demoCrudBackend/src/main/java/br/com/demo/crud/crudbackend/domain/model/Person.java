package br.com.demo.crud.crudbackend.domain.model;

import br.com.demo.crud.crudbackend.domain.enums.Country;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

/**
 * Person entity data
 */
@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "phone")
  private String phone;

  @Column(name = "birthDay")
  private LocalDate birthDay;

  @Column(name = "zip_code")
  private String zipCode;

  @Column(name = "address")
  private String address;

  @Column(name = "email")
  private String email;

  @Column(name = "country")
  private Country country;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return id.equals(person.id);
  }


}
