import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';

//firebase stuff
//import { AngularFireModule } from 'angularfire2';
import { environment } from '../environments/environment';

//md modules
import { MatButtonModule, MatIconModule, MatDialogModule, MatInputModule } from '@angular/material';

//services
import { AuthService } from './services/auth.service';
import { GigsService } from './services/gigs.service';

import { HeaderComponent } from './header/header.component';
import { ResultsPageComponent } from './results-page/results-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { FooterComponent } from './footer/footer.component';
import { ArtistSearchResultComponent } from './artist-search-result/artist-search-result.component';
import { ArtistProfileComponent } from './artist-profile/artist-profile.component';
import { VenueSearchResultComponent } from './venue-search-result/venue-search-result.component';
import { VenueProfileComponent } from './venue-profile/venue-profile.component';
import { FanProfileComponent } from './fan-profile/fan-profile.component';
import { LoginComponent } from './login/login.component';

const appRoutes: Routes = [
	{path: 'home', component: HomePageComponent},
  {path: 'results', component: ResultsPageComponent},
  {path: 'artist-profile/:id', component: ArtistProfileComponent},
  {path: 'venue-profile/:id', component: VenueProfileComponent},
	{path: 'fan-profile/:id', component: FanProfileComponent},
	{path: '', redirectTo: '/results', pathMatch: 'full'},
	{path: '**', component: PageNotFoundComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ResultsPageComponent,
    HomePageComponent,
    PageNotFoundComponent,
    FooterComponent,
    ArtistSearchResultComponent,
    ArtistProfileComponent,
    VenueSearchResultComponent,
    VenueProfileComponent,
    FanProfileComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatIconModule,
    MatDialogModule,
    MatInputModule,
    RouterModule.forRoot(appRoutes)
    //, AngularFireModule.initializeApp(environment.firebase)
  ],
  providers: [
    AuthService,
    GigsService
  ],
  entryComponents: [
    LoginComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
