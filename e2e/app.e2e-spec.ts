import { RevMuzikPage } from './app.po';

describe('rev-muzik App', () => {
  let page: RevMuzikPage;

  beforeEach(() => {
    page = new RevMuzikPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
