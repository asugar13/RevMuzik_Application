// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.

export const environment = {
  production: false,
  firebase: {
    apiKey: "AIzaSyDn-U21Z4dXaO-eRV9S25qXxioc15gmHis",
    authDomain: "revmuzik-mvp.firebaseapp.com",
    databaseURL: "https://revmuzik-mvp.firebaseio.com",
    projectId: "revmuzik-mvp",
    storageBucket: "revmuzik-mvp.appspot.com",
    messagingSenderId: "923746584661"
  }
};
