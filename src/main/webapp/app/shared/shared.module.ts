import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { SentimentAnalysisSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [SentimentAnalysisSharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [SentimentAnalysisSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SentimentAnalysisSharedModule {
  static forRoot() {
    return {
      ngModule: SentimentAnalysisSharedModule
    };
  }
}
