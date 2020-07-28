import { NgModule } from '@angular/core';
import { MatTabsModule } from '@angular/material/tabs';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatTableModule} from '@angular/material/table';
import {MatDialogModule} from '@angular/material/dialog';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatDividerModule} from '@angular/material/divider';
import {MatListModule} from '@angular/material/list';
import {MatGridListModule} from '@angular/material/grid-list';

const MaterialModuleCopmonents = [MatTabsModule,
MatSelectModule,
MatDatepickerModule,
MatNativeDateModule,
MatTableModule,
MatDialogModule,
MatCardModule,
MatToolbarModule,
MatButtonModule,
MatDividerModule,
MatListModule,
MatGridListModule
];

@NgModule({
  imports: [MaterialModuleCopmonents],
  exports: [MaterialModuleCopmonents]


})
export class MaterialModule { }
