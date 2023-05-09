import { Component } from '@angular/core';
import { MatIconRegistry } from '@angular/material/icon';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.scss']
})
export class LayoutComponent {

  constructor( private domSanitizer: DomSanitizer,
              private matIconRegistry: MatIconRegistry){

    this.matIconRegistry.addSvgIcon("git", this.domSanitizer.bypassSecurityTrustResourceUrl("../../../assets/img/github-circle-white-transparent.svg")); 
  }

}
