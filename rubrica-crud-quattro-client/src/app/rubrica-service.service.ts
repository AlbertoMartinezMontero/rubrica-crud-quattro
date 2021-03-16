import { Injectable } from '@angular/core';
import { Contatto } from './model/contatto';

@Injectable({
  providedIn: 'root'
})
export class RubricaServiceService {

  contatti: Contatto[] = [];

  constructor() { }
}
