import { NgModule } from '@angular/core';

import { SentimentAnalysisSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
  imports: [SentimentAnalysisSharedLibsModule],
  declarations: [JhiAlertComponent, JhiAlertErrorComponent],
  exports: [SentimentAnalysisSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class SentimentAnalysisSharedCommonModule {}
