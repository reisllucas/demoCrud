import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator'; 
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatSortModule } from '@angular/material/sort';
import { MatCardModule } from '@angular/material/card';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule, } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatNativeDateModule, MAT_DATE_LOCALE} from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { IConfig, provideNgxMask,  NgxMaskDirective, NgxMaskPipe } from 'ngx-mask';

import { PersonListComponent } from './person-list/person-list.component';
import { PersonFormComponent } from './person-form/person-form.component';
import { PersonRoutingModule } from './person-routing.module';
import { DialogModule } from '../dialog/dialog.module'

const maskConfig: Partial<IConfig> = {
  validation: false,
};


@NgModule({
  declarations: [
    PersonListComponent,
    PersonFormComponent
  ],
  imports: [
    CommonModule,
    MatIconModule,
    MatButtonModule,
    PersonRoutingModule,
    MatTableModule,
    MatPaginatorModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSortModule,
    MatCardModule,
    MatAutocompleteModule,
    MatDividerModule,
    MatNativeDateModule,
    MatDatepickerModule,
    NgxMaskDirective,
    NgxMaskPipe,
    DialogModule

  ],
  providers:[
    {provide: MAT_DATE_LOCALE, useValue: 'en-US'},
    provideNgxMask(maskConfig)
  ]
})
export class PersonModule { }
