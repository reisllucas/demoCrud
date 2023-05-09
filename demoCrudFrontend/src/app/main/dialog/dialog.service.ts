import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmDialogComponent } from './confirm-dialog/confirm-dialog.component';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class DialogService {

  private _unsubscribeAll = new Subject();
  constructor(public dialog: MatDialog) { }


  openConfirmDialog(title: string, message: string, onOk: any){
    const dialogRef = this.dialog.open(ConfirmDialogComponent,{
      panelClass: 'app-confirm-dialog',
      autoFocus: false,
      data: {title, message},
      width: '40%'
    });

    dialogRef.afterClosed()
    .pipe(takeUntil(this._unsubscribeAll))
    .subscribe(async (response) => {
      if (!response || !response.ok) {
        return;
      } else {
        onOk();
      }
    });
  }
}
