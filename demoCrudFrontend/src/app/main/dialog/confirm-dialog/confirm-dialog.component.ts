import { Component, Inject } from '@angular/core';
import { MatDialogRef,MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-confirm-dialog',
  templateUrl: './confirm-dialog.component.html',
  styleUrls: ['./confirm-dialog.component.scss']
})
export class ConfirmDialogComponent {

  title: string;
  message: string;

  constructor(
    public matDialogRef: MatDialogRef<ConfirmDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ){}

  ngOnInit(): void {
    this.title = this.data.title;
    this.message = this.data.message
  }

  doOk() {
    this.doClose(true);
  }

  doCancel() {
    this.doClose(false)
  }

  doClose(ok : boolean) {
    this.matDialogRef.close({ok})
  }
}
