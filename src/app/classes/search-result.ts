import { Artist } from './artist';
import { Venue } from './venue';

export class SearchResult {

//has these properties
//artist{name:'jeremy fox', imageUrl: 'linktoimage'}
//venue{ name: string, address: string}
//date

	artist: Artist;
	venue: Venue;
	date: string; //keep it as string for now
}
