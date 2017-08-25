import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import 'hammerjs';

import { AppComponent } from './app.component';

//md modules
import { MdButtonModule, MdIconModule } from '@angular/material';

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
    FanProfileComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MdButtonModule,
    MdIconModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
