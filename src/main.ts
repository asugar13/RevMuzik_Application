import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

<<<<<<< HEAD
import 'hammerjs';

=======
>>>>>>> 05fd8ace934fb012d9bb4617fcade2b5044beb5f
if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule);
