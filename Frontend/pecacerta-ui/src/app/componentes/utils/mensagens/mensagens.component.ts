import { Component, Input } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-mensagens',
  template: `<small class="p-invalid" *ngIf="hasError()">
  {{ text }}
</small>`,
  styles: []
})
export class MensagensComponent {

  @Input() error: string;
  @Input() control: FormControl;
  @Input() text: string;

  hasError(): Boolean {
    return this.control.hasError(this.error) && this.control.dirty;
  }
}
