

//class for populating gigboxes
//

export class Gig {

	idshow: any;
	description: string;
	name: any;
	endDateTime: any;
	startDateTime: any;
	imagepath: any;
	artist: any;
	venue: any;

	constructor(idshow, description, name, endDateTime, startDateTime, imagepath, artist, venue){
		this.idshow = idshow;//user does not provide this
		this.description = description;
		this.name = name;
		this.endDateTime = endDateTime;
		this.startDateTime = startDateTime;
		this.imagepath = imagepath;
		this.artist = artist;
		this.venue = venue;
	}
}
