import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import 'hammerjs';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';

//firebase stuff
import { AngularFireModule } from 'angularfire2';
import { environment } from '../environments/environment';

//material design modules
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatChipsModule } from '@angular/material/chips';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material';
import { MatStepperModule } from '@angular/material/stepper';

//services
import { AuthService } from './services/auth.service';
import { GigsService } from './services/gigs.service';
import { UserService } from './services/user.service';
import { UploadFileService } from './services/upload-file.service';

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
import { PhotoUploadComponent } from './photo-upload/photo-upload.component';
import { DetailsUploadComponent } from './details-upload/details-upload.component';
import { ListUploadComponent } from './list-upload/list-upload.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { CreateGigComponent } from './create-gig/create-gig.component';
import { GigDetailsComponent } from './gig-details/gig-details.component';

const appRoutes: Routes = [
	{path: 'home', component: HomePageComponent},
  {path: 'results', component: ResultsPageComponent},
  {path: 'gig-details/:id', component: GigDetailsComponent},
  {path: 'artist-profile/:id', component: ArtistProfileComponent},
  {path: 'venue-profile/:id', component: VenueProfileComponent},
  {path: 'fan-profile/:id', component: FanProfileComponent},
  {path: 'create-account', component: CreateAccountComponent},
	{path: 'create-gig', component: CreateGigComponent},
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
    LoginComponent,
    PhotoUploadComponent,
    DetailsUploadComponent,
    ListUploadComponent,
    CreateAccountComponent,
    CreateGigComponent,
    GigDetailsComponent
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
    MatSelectModule,
    MatChipsModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatStepperModule,
    RouterModule.forRoot(appRoutes),
    AngularFireModule.initializeApp(environment.firebase)
  ],
  providers: [
    AuthService,
    GigsService,
    UserService,
    UploadFileService
  ],
  entryComponents: [
    LoginComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
