package org.wcci.apimastery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.Storage.AlbumStorage;
import org.wcci.apimastery.Storage.SongStorage;
import org.wcci.apimastery.pojos.Album;
import org.wcci.apimastery.pojos.Song;

@Component
public class Populator implements CommandLineRunner {

    private AlbumStorage albumStorage;

    private SongStorage songStorage;

    public Populator(AlbumStorage albumStorage, SongStorage songStorage){
        this.albumStorage = albumStorage;
        this.songStorage = songStorage;
    }

    //title, record label, rating, imageurl, artist, comments

    @Override
    public void run(String... args) throws Exception{
        
//album1 - currents

        Album album1 = new Album("Currents", "Modular Recordings", 8.9, "https://media.pitchfork.com/photos/5929ae46c0084474cd0c188c/1:1/w_600/04192b63.jpg", "Tame Impala", "surreal listening experience");
        albumStorage.saveAlbum(album1);

        Song song1 = new Song(album1, "Let It Happen", 467, 7.6, "https://open.spotify.com/track/2X485T9Z5Ly0xyaghN73ed?si=7d01de81dd684007", "i kind of wanted it to be over");
        songStorage.saveSong(song1);
        Song song2 = new Song(album1, "Nangs", 107, 8.0, "https://open.spotify.com/track/1cCbsojaA6GIT7Y3zuMJ1q?si=ae26ceb5c4f94cb5", "i'm intrigued?");
        songStorage.saveSong(song2);
        Song song3 = new Song(album1, "The Moment", 255, 9.4, "https://open.spotify.com/track/1UYj8qTWjneZJDVjUMwMub?si=d5347fd05c224cbf", "this song is fun");
        songStorage.saveSong(song3);
        Song song4 = new Song(album1, "Yes I'm Changing", 270, 9.8, "https://open.spotify.com/track/0xtIp0lgccN85GfGOekS5L?si=b534d54523884056", "so good");
        songStorage.saveSong(song4);
        Song song5 = new Song(album1, "Eventually", 318, 7.0, "https://open.spotify.com/track/5M4yti0QxgqJieUYaEXcpw?si=9ebf969e26104205", "it's a yes from me");
        songStorage.saveSong(song5);
        Song song6 = new Song(album1, "Gossip", 55, 6.8, "https://open.spotify.com/track/79chzfFIIq7cHkqcYYORk0?si=2d894318a38b434b", "sounds like something out of a sad sci-fi movie");
        songStorage.saveSong(song6);
        Song song7 = new Song(album1, "The Less I Know The Better", 216, 10.0, "https://open.spotify.com/track/6K4t31amVTZDgR3sKmwUJJ?si=e5a78748fa794061", "a mood lifter");
        songStorage.saveSong(song7);
        Song song8 = new Song(album1, "Past Life", 228, 8.8, "https://open.spotify.com/track/4a9fW33mYR8LhXBOLUhbfF?si=5d45dff74a0342a3", "this is interesting");
        songStorage.saveSong(song8);
        Song song9 = new Song(album1, "Disciples", 108, 6.0, "https://open.spotify.com/track/2gNfxysfBRfl9Lvi9T3v6R?si=80af7dacec1e4e35", "it's okay");
        songStorage.saveSong(song9);
        Song song10 = new Song(album1, "'Cause I'm A Man", 241, 5.5, "https://open.spotify.com/track/2O99aywAVBhaPrsiJ6zbSS?si=c556ac3e6eef4dea", "not my faovrite");
        songStorage.saveSong(song10);
        Song song11 = new Song(album1, "Reality In Motion", 252, 8.5, "https://open.spotify.com/track/3I7OmVsk4Hm5LBbs2GmhlD?si=bfdc9635354b49eb", "groovy");
        songStorage.saveSong(song11);
        Song song12 = new Song(album1, "Love/Paranoia", 185, 8.9, "https://open.spotify.com/track/5h9hkYIBWTZYFRmF6Iz1gt?si=9605128e04944d5d", "pretty sounds");
        songStorage.saveSong(song12);
        Song song13 = new Song(album1, "New Person, Same Old Mistakes", 363, 9.5, "https://open.spotify.com/track/52ojopYMUzeNcudsoz7O9D?si=88838a85b3ec42be", "incredible");
        songStorage.saveSong(song13);

// album2 - igor

        Album album2 = new Album("IGOR", "Columbia Records", 8.0, "https://fringster.com/content/images/39034.jpg", "Tyler The Creator", "this album is intense");
        albumStorage.saveAlbum(album2);

        Song song14 = new Song(album2, "IGOR'S THEME", 200, 5.0, "https://open.spotify.com/track/51RN0kzWd7xeR4th5HsEtW?si=703f6c06956d4556","not the best");
        songStorage.saveSong(song14);
        Song song15 = new Song(album2, "EARFQUAKE",  190, 8.5, "https://open.spotify.com/track/5hVghJ4KaYES3BFUATCYn0?si=eef11ee9f4bd4636", "so catchy");
        songStorage.saveSong(song15);
        Song song16 = new Song(album2, "I THINK", 212, 9.8, "https://open.spotify.com/track/4f8Mh5wuWHOsfXtzjrJB3t?si=b1e4de41f7b34862", "such a bop");
        songStorage.saveSong(song16);
        Song song17 = new Song(album2, "EXACTLY WHAT YOU RUN FROM YOU END UP CHASING", 14, 9.2, "https://open.spotify.com/track/5e4LIAQI0bClLazNf2gZV0?si=39754eb6f39e4f1b", "this is just someone talking");
        songStorage.saveSong(song17);
        Song song18 = new Song(album2, "RUNNING OUT OF TIME", 177, 9.2, "https://open.spotify.com/track/5QvBXUm5MglLJ3iBfTX2Wo?si=504d525213f443ec", "really cool song");
        songStorage.saveSong(song18);
        Song song19 = new Song(album2, "NEW MAGIC WAND", 195, 10.0, "https://open.spotify.com/track/5QvBXUm5MglLJ3iBfTX2Wo?si=a65832835aa94090", "this gave me brain damage");
        songStorage.saveSong(song19);
        Song song20 = new Song(album2, "A BOY IS A GUN*", 210, 7.9, "https://open.spotify.com/track/1nXZnTALNXiPlvXotqHm66?si=9180825aa8f14fd4", "i love it" );
        songStorage.saveSong(song20);
        Song song21 = new Song(album2, "PUPPET", 179, 9.0, "https://open.spotify.com/track/0wEC0GNF74lAqrEFZJMl1m?si=ad9e6e38866540ec", "so good");
        songStorage.saveSong(song21);
        Song song22 = new Song(album2, "WHAT'S GOOD", 205, 4.5, "https://open.spotify.com/track/6bOkaEXc5CopinGazSLokx?si=7bf65530364941fa", "i don't like this song");
        songStorage.saveSong(song22);
        Song song23 = new Song(album2, "GONE,GONE/THANK YOU", 375, 8.8, "https://open.spotify.com/track/1hz7SRTGUNAtIQ46qiNv2p?si=fc0dfc3d155f4b39", "really cool song");
        songStorage.saveSong(song23);
        Song song24 = new Song(album2, "I DON'T LOVE YOU ANYMORE", 161, 9.0, "https://open.spotify.com/track/5A0M6B0RBSXSNWv0wcppZ9?si=2fcad5371d2c4482", "amazing");
        songStorage.saveSong(song24);
        Song song25 = new Song(album2, "ARE WE STILL FRIENDS?", 265, 7.5, "https://open.spotify.com/track/5TxRUOsGeWeRl3xOML59Ai?si=c4fb322d7b93403b", "love it");
        songStorage.saveSong(song25);

// album3 - in rainbows
        
        Album album3 = new Album("In Rainbows", "LLLP LLP", 9.8, "https://images-na.ssl-images-amazon.com/images/I/A1MwaIeBpwL._SL1500_.jpg", "Radiohead", "a masterpiece");
        albumStorage.saveAlbum(album3);

        Song song26 = new Song(album3, "15 Step", 237, 10.0, "https://open.spotify.com/track/4oXg7xT4ksBxHTx8PcmSXw?si=0740afe7440d40f9", "this is such a cool song");
        songStorage.saveSong(song26);
        Song song27 = new Song(album3, "Bodysnatchers", 242, 7.0, "https://open.spotify.com/track/4pWIwnnqx8k01fuF95UMIg?si=64092056ed60441e", "very angsty");
        songStorage.saveSong(song27); 
        Song song28 = new Song(album3, "Nude", 255, 9.7, "https://open.spotify.com/track/35YyxFpE0ZTOoqFx5bADW8?si=57ebd03858144ecb", "this song is so beautiful");
        songStorage.saveSong(song28);
        Song song29 = new Song(album3, "Weird Fishes/ Arpeggi", 218, 10.0, "https://open.spotify.com/track/4wajJ1o7jWIg62YqpkHC7S?si=fb0ced0f754742c6", "this song makes me feel things");
        songStorage.saveSong(song29);
        Song song30 = new Song(album3, "All I Need", 228, 10.0, "https://open.spotify.com/track/5Qv2Nby1xTr9pQyjkrc94J?si=6bf06338a3664622", "don't listen to this unless you want to be sad");
        songStorage.saveSong(song30);
        Song song31 = new Song(album3, "Faust Arp", 129, 7.9, "https://open.spotify.com/track/15irEKZ9D6FQqLoZ1qJ1Cx?si=b01eb34f7ea244c3", "soft and melancholy");
        songStorage.saveSong(song31);
        Song song32 = new Song(album3, "Reckoner", 290, 9.5, "https://open.spotify.com/track/02ppMPbg1OtEdHgoPqoqju?si=05770c76fdd64a72", "let's be real, his voice is stunning");
        songStorage.saveSong(song32);
        Song song33 = new Song(album3, "House Of Cards", 328, 10.0, "https://open.spotify.com/track/48X4D1FYOShPz2VF3YdfCF?si=7223def5a54341c5", "i have no words");
        songStorage.saveSong(song33);
        Song song34 = new Song(album3, "Jigsaw Falling Into Place", 248, 8.8, "https://open.spotify.com/track/0YJ9FWWHn9EfnN0lHwbzvV?si=717fa6f80a194c10", "i like the grungy vibes");
        songStorage.saveSong(song34);
        Song song35 = new Song(album3, "VideoTape", 279, 9.5, "https://open.spotify.com/track/4T1iiabe7G0UjWQJCY6NE2?si=280fae9908034050", "it's just so pretty");
        songStorage.saveSong(song35);

//album4 - brothers

        Album album4 = new Album("Brothers", "Nonesuch Records", 9.7, "https://upload.wikimedia.org/wikipedia/en/9/93/The_Black_Keys_-_Brothers.jpg", "The Black Keys", "a really fun and diverse album");
        albumStorage.saveAlbum(album4);

        Song song36 = new Song(album4, "Everlasting Light", 203, 10.0, "https://open.spotify.com/track/6dU5RxthbuaN31bRbEDlNw?si=8d2aba9f56594e70", "an absolute banger");
        songStorage.saveSong(song36);
        Song song37 = new Song(album4, "Next Girl", 198, 8.5, "https://open.spotify.com/track/2UE4m8egf0aREmOi47sDOk?si=a6a48b2574e84eba", "such a good song");
        songStorage.saveSong(song37);
        Song song38 = new Song(album4, "Tighten Up", 211, 10.0, "https://open.spotify.com/track/2MVwrvjmcdt4MsYYLCYMt8?si=740ead72d6774b7e", "truly wild");
        songStorage.saveSong(song38);
        Song song39 = new Song(album4, "Howlin' for You", 191, 10.0, "https://open.spotify.com/track/0grFc6klR3hxoHLcgCYsF4?si=350112f3d98b4f7c", "hard not to dance to");
        songStorage.saveSong(song39);
        Song song40 = new Song(album4, "She's Long Gone", 186, 9.7, "https://open.spotify.com/track/26ZnmGlPGXaOzPDydAP9D5?si=c4e80182c01e406d", "this song is bad ass");
        songStorage.saveSong(song40);
        Song song41 = new Song(album4, "Black Mud", 129, 7.8, "https://open.spotify.com/track/2y42MmBCfEhqIkFAJs0V8Z?si=83a5658785834730", "pretty cool instrumental");
        songStorage.saveSong(song41);
        Song song42 = new Song(album4, "The Only One", 300, 9.8, "https://open.spotify.com/track/3QHA3SBpz2SDEpI1HuMT0e?si=2bac50d4aa804101", "love love love this one");
        songStorage.saveSong(song42);
        Song song43 = new Song(album4, "Too Afraid To Love You", 204, 7.7, "https://open.spotify.com/track/1comODdI862K7ei34XZRa4?si=ea9da313e6d24696", "really interesting sound");
        songStorage.saveSong(song43);
        Song song44 = new Song(album4, "Ten Cent Pistol", 269, 8.2, "https://open.spotify.com/track/2qoLCpTRYv6h8Vx94hxkvl?si=c5a414082e874aea", "this song is delicious");
        songStorage.saveSong(song44);
        Song song45 = new Song(album4, "Sinister Kid", 224, 8.9, "https://open.spotify.com/track/78krcD2vFUXJ3Y0XXeiHWH?si=6994ffcbbb56421c", "this song is pretty good");
        songStorage.saveSong(song45);
        Song song46 = new Song(album4, "The Go Getter", 216, 9.2, "https://open.spotify.com/track/3Wwd0W89C56cCRilh8HFNs?si=14b89a0c5c9e4c93", "i enjoy this");
        songStorage.saveSong(song46);
        Song song47 = new Song(album4, "I'm Not the One", 229, 8.0, "https://open.spotify.com/track/4c15DmbPf9g3HNPipLBBu0?si=fb09e0b4ecff4bee", "i don't love this");
        songStorage.saveSong(song47);
        Song song48 = new Song(album4, "Unknown Brother", 239, 7.5, "https://open.spotify.com/track/0BQH5uHglCuHVImyCjOOHc?si=4c8a50ce8bce45eb", "this song is okay");
        songStorage.saveSong(song48);
        Song song49 = new Song(album4, "Never Gonna Give You Up", 218, 9.9, "https://open.spotify.com/track/4qjqO5m5e5vebk9upd7xUU?si=a558d9bdce5d4468", "really like this one!");
        songStorage.saveSong(song49);
        Song song50 = new Song(album4, "These Days", 311, 8.4, "https://open.spotify.com/track/3ghXwIS6cr3P5InauKlqFy?si=25401e981f644953", "it's slower than the others, i like it");
        songStorage.saveSong(song50);

//album5 - hurry up, we're dreaming

        Album album5 = new Album("Hurry Up, We're Dreaming", "Mute/Naive", 10.0, "https://media.pitchfork.com/photos/5929b14c9d034d5c69bf49d5/1:1/w_600/be990fa7.jpg", "M83", "this entire album is stunning");
        albumStorage.saveAlbum(album5);

        Song song51 = new Song(album5, "Intro", 322, 9.0, "https://open.spotify.com/track/6XDFFeinPXgy3auyC7huoC?si=2a8b98c5c52c4648", "this song sounds like having an epiphany");
        songStorage.saveSong(song51);
        Song song52 = new Song(album5, "Midnight City", 241, 10.0, "https://open.spotify.com/track/1eyzqe2QqGZUmfcPZtrIyt?si=2033ce4435574da2", "this is literally the best song i've ever heard");
        songStorage.saveSong(song52);
        Song song53 = new Song(album5, "Reunion", 235, 9.8, "https://open.spotify.com/track/7zZkPiqHnL7icGGb4Almf6?si=73a57bd5cd164995", "not sure what they're saying but i understand.");
        songStorage.saveSong(song53);
        Song song54 = new Song(album5, "Where The Boats Go", 106, 8.5, "https://open.spotify.com/track/5cF3UVkFX8k9WZP4TyscYi?si=98a139bc55ae43d7", "magical");
        songStorage.saveSong(song54);
        Song song55 = new Song(album5, "Wait", 343, 9.7, "https://open.spotify.com/track/3rTnGUeDrnZV22DvRuUuXr?si=855cd02eb24f4269", "so dreamy");
        songStorage.saveSong(song55);
        Song song56 = new Song(album5, "Raconte-Moi Une Histoire", 244, 6.8, "https://open.spotify.com/track/0SeMmdPt7Ksu1fIAgnPIOG?si=ab896540bfba4714", "not my favorite");
        songStorage.saveSong(song56);
        Song song57 = new Song(album5, "Train To Pluton", 75, 7.0, "https://open.spotify.com/track/5ovJD4orq3aCbJnQHMwKmt?si=59ab2fde08064681", "really short song");
        songStorage.saveSong(song57);
        Song song58 = new Song(album5, "Claudia Lewis", 271, 8.5, "https://open.spotify.com/track/2OYMcth0dXHv5qcoli4HPv?si=e0793c9b8b6a4872", "i like how fun it is");
        songStorage.saveSong(song58);
        Song song59 = new Song(album5, "This Bright Flash", 141, 7.0, "https://open.spotify.com/track/1oesncxikaS73FcSGECZep?si=2c8842504c014af6", "really neat song");
        songStorage.saveSong(song59);
        Song song60 = new Song(album5, "When Will You Come Home?", 83, 6.8, "https://open.spotify.com/track/0ILPnIuTZ2TJ8pbYxmOHzF?si=f19255f2c6e84d72", "makes me sleepy");
        songStorage.saveSong(song60);
        Song song61 = new Song(album5, "Soon, My Friend", 189, 7.0, "https://open.spotify.com/track/11GXRfMCSD2wdwgEXXEEc4?si=6e2ca84fdace46ba", "so relaxing");
        songStorage.saveSong(song61);
        Song song62 = new Song(album5, "My Tears Are Becoming A Sea", 151, 9.0, "https://open.spotify.com/track/1Fwj0wThn3kTg8D7KgWdsU?si=19ae21ecb64e4b7c", "this was intense");
        songStorage.saveSong(song62);
        Song song63 = new Song(album5, "New Map", 262, 9.4, "https://open.spotify.com/track/6GdbwI8ytDROXDv1G7p34o?si=bf4dd45d291a4109", "really pretty song");
        songStorage.saveSong(song63);
        Song song64 = new Song(album5, "Ok Pal", 238, 6.9, "https://open.spotify.com/track/0xAOmpRlrqsr0afkC3NzVU?si=d1b1be9bc870468b", "really fun");
        songStorage.saveSong(song64);
        Song song65 = new Song(album5, "Another Wave From You", 113, 8.5, "https://open.spotify.com/track/1XVO06yjToSOSTTaL6YqV5?si=b5091766ab1d4720", "honestly amazing");
        songStorage.saveSong(song65);
        Song song66 = new Song(album5, "Splendor", 307, 8.7, "https://open.spotify.com/track/0NOQxyVgo8javoH9H4wvU7?si=562d0b82fc78473d", "this is really soft and relaxing");
        songStorage.saveSong(song66);
        Song song67 = new Song(album5, "Year One, One Ufo", 197, 6.8, "https://open.spotify.com/track/6QOfkcfdrEZ2nwi5R9KJTK?si=798fc3bd6a354b57", "i don't like this song");
        songStorage.saveSong(song67);
        Song song68 = new Song(album5, "Fountains", 81, 7.0, "https://open.spotify.com/track/4S1TcxIV42zhABqofPxsvN?si=31d643470fc3459b", "so pretty");
        songStorage.saveSong(song68);
        Song song69 = new Song(album5, "Steve McQueen", 228, 8.5, "https://open.spotify.com/track/5iXWkUMZYRZADokxXnniYt?si=37009806adae44a7", "ugh so good");
        songStorage.saveSong(song69);
        Song song70 = new Song(album5, "Echoes Of Mine", 219, 7.0, "https://open.spotify.com/track/5jWvCQXM7plS3T9FAAeBCR?si=213dd1ace5ce4617", "this is cool");
        songStorage.saveSong(song70);
        Song song71 = new Song(album5, "Klaus I Love You", 104, 6.8, "https://open.spotify.com/track/4XeX53Xs0zZRLGwIm45aDf?si=7ef9d7c664434200", "such a unique sound");
        songStorage.saveSong(song71);
        Song song72 = new Song(album5, "Outro", 189, 7.0, "https://open.spotify.com/track/2QVmiA93GVhWNTWQctyY1K?si=1ccff83209f94c7d", "absolutely wild");
        songStorage.saveSong(song72);

//album6 - unknown pleasures

        Album album6 = new Album("Unknown PLeasures", "Factory Records", 8.9, "https://maxhalford.github.io/img/blog/unknown-pleasures/album.png", "Joy Division", "very dark and grungy");
        albumStorage.saveAlbum(album6);

        Song song73 = new Song(album6, "Disorder", 212, 10.0, "https://open.spotify.com/track/2OPmhk5vO4qiYE4LEAC9hs?si=89f3d6e22e614c34", "love this song");
        songStorage.saveSong(song73);
        Song song74 = new Song(album6, "Day Of The Lords", 289, 7.4, "https://open.spotify.com/track/4sv6PcG4kX19kTP5HUV4VN?si=93f86c69d9ab4e12", "boring but still good");
        songStorage.saveSong(song74);
        Song song75 = new Song(album6, "Candidate", 185, 10.0, "https://open.spotify.com/track/4dYME2vEklDwBIYYxZ1tRx?si=8de8a043e27847f8", "this is creepy and slow");
        songStorage.saveSong(song75);
        Song song76 = new Song(album6, "Insight", 268, 10.0, "https://open.spotify.com/track/0ETHMWVurMZA72k2uUESfq?si=486c7ca02705482f", "i like this");
        songStorage.saveSong(song76);
        Song song77 = new Song(album6, "New Dawn Fades", 288, 10.0, "https://open.spotify.com/track/6Ox9HWLHipsG6RH2a3eB8h?si=366add2885054480", "oh yeah, love it");
        songStorage.saveSong(song77);
        Song song78 = new Song(album6, "She's Lost Control", 237, 10.0, "https://open.spotify.com/track/5YiSSBURCIz0qlOoL3la8w?si=353f054e51b24e5e", "a whole vibe");
        songStorage.saveSong(song78);
        Song song79 = new Song(album6, "Shadowplay", 235, 10.0, "https://open.spotify.com/track/1HIV7KpOnHL32AKth0l1eU?si=92e4266c67be4979", "angsty");
        songStorage.saveSong(song79);
        Song song80 = new Song(album6, "Wilderness", 158, 10.0, "https://open.spotify.com/track/5YCjJwmUKpUQRzgPDm3iFm?si=c69147d3e9f943a8", "cool song");
        songStorage.saveSong(song80);
        Song song81 = new Song(album6, "Interzone", 136, 10.0, "https://open.spotify.com/track/4yvgL1k1WkuSEHkMPhDF5X?si=53ef5781035b4b72", "this is a bop");
        songStorage.saveSong(song81);
        Song song82 = new Song(album6, "I Remember Nothing", 355, 10.0, "https://open.spotify.com/track/2kRkLYYspTSmsVjME4Vuke?si=43ec101e1dc94262", "moody");
        songStorage.saveSong(song82);

//album7 - the 1975

        Album album7 = new Album("The 1975", "Dirty Hit Records", 10.0, "https://upload.wikimedia.org/wikipedia/en/0/03/The_1975_%28album%29_by_The_1975.png", "The 1975", "this album is full of bangers");
        albumStorage.saveAlbum(album7);

        Song song83 = new Song(album7, "The 1975", 79, 7.6, "https://open.spotify.com/track/2Z0GMIYxTHz0cL90PGwJaZ?si=7dfd3abedfbe460d", "i love it");
        songStorage.saveSong(song83);
        Song song84 = new Song(album7, "The City", 206, 9.8, "https://open.spotify.com/track/0a612uSmQ7zXV54buD9LSn?si=1a8ae1c1239e4332", "this song is so fun");
        songStorage.saveSong(song84);
        Song song85 = new Song(album7, "M.O.N.E.Y", 216, 9.4, "https://open.spotify.com/track/4ehjV3FF2eehHdt91Bx2LX?si=19468a9ae9ea45a0", "love this energy");
        songStorage.saveSong(song85);
        Song song86 = new Song(album7, "Chocolate", 224, 8.0, "https://open.spotify.com/track/44Ljlpy44mHvLJxcYUvTK0?si=da450b23c77d4530", "this song is overrated");
        songStorage.saveSong(song86);
        Song song87 = new Song(album7, "Sex", 206, 10.0, "https://open.spotify.com/track/0wIFAHbaUucA8mog7Y2IDD?si=531331f4560e4711", "sooo good");
        songStorage.saveSong(song87);
        Song song88 = new Song(album7, "Talk!", 167, 9.5, "https://open.spotify.com/track/6IGmJY5zrTC4HF31CP2Dhj?si=9a4b8da244e24b95", "really cool song");
        songStorage.saveSong(song88);
        Song song89 = new Song(album7, "An Encounter", 74, 7.3, "https://open.spotify.com/track/2hWo08miXIpr0QphDeTTiV?si=79e0b37fa0ce480e", "really interesting sounds");
        songStorage.saveSong(song89);
        Song song90 = new Song(album7, "Heart Out", 202, 9.9, "https://open.spotify.com/track/3srofwWlFzNqgSmRI9YbFY?si=97a5a3339d6840a8", "makes you want to dance");
        songStorage.saveSong(song90);
        Song song91 = new Song(album7, "Settle Down", 239, 8.9, "https://open.spotify.com/track/36YLqJHsNHHODwX5gDPEBb?si=2fa83b1be53945cf", "fun to dance to");
        songStorage.saveSong(song91);
        Song song92 = new Song(album7, "Robbers", 254, 10.0, "https://open.spotify.com/track/6BkUBVHoGXjOF3bpBkQ4aP?si=7a6b7705eb4a40e9", "this song sounds the best played loudly in a car");
        songStorage.saveSong(song92);
        Song song93 = new Song(album7, "Girls", 254, 7.9, "https://open.spotify.com/track/6d8jFIWMRwhVYe7SCQwlqL?si=2b227f89cb084f6d", "very fun");
        songStorage.saveSong(song93);
        Song song94 = new Song(album7, "12", 79, 9.5, "https://open.spotify.com/track/4OAYpdjDwCpUIFxIpmrDSE?si=5d63e42ed436462d", "so beautiful");
        songStorage.saveSong(song94);
        Song song95 = new Song(album7, "She Way Out", 239, 8.8, "https://open.spotify.com/track/4XVaKcjTMKPY1z5x9fCBbp?si=481b59babc1e49ce", "not the best");
        songStorage.saveSong(song95);
        Song song96 = new Song(album7, "Menswear", 206, 10.0, "https://open.spotify.com/track/016jIui162qwzuYcIJzXat?si=cf2acf9edaa543da", "this song is so good");
        songStorage.saveSong(song96);
        Song song97 = new Song(album7, "Pressure", 221, 6.5, "https://open.spotify.com/track/6tKBCvbaUoBRPk5kHH836j?si=67a273ffda644577", "very boppy");
        songStorage.saveSong(song97);
        Song song98 = new Song(album7, "Is There Somebody Who Can Watch You", 174, 10.0, "https://open.spotify.com/track/5vTRduHPw2BumSJTcaNm2E?si=5b89612004ef48c3", "so sad but so good");
        songStorage.saveSong(song98);

//album8 - depression cherry

        Album album8 = new Album("Depression Cherry", "Sub Pop Records", 10.0, "https://media.pitchfork.com/photos/5929aed09d034d5c69bf45f4/1:1/w_320/9c17ddf5.jpg", "Beach House", "such a soft n pretty album");
        albumStorage.saveAlbum(album8);

        Song song99 = new Song(album8, "Levitation", 354, 9.3, "https://open.spotify.com/track/7EWDXdu3BzLLCuAGrAx4RT?si=4e3830df366543e7", "so pretty");
        songStorage.saveSong(song99);
        Song song100 = new Song(album8, "Sparks", 321, 9.7, "https://open.spotify.com/track/5ORY1GDl3lpEDyU1CzSq26?si=88f0f92f8cf04da0", "super interesting sound");
        songStorage.saveSong(song100);
        Song song101 = new Song(album8, "Space Song", 320, 8.4, "https://open.spotify.com/track/7H0ya83CMmgFcOhw0UB6ow?si=1614d8290af0496b", "this song just hits different");
        songStorage.saveSong(song101);
        Song song102 = new Song(album8, "Beyond Love", 265, 9.0, "https://open.spotify.com/track/2J2hSpUJ3aQXx81q2qqxMj?si=4845268e870d4e50", "i love it");
        songStorage.saveSong(song102);
        Song song103 = new Song(album8, "10:37", 228, 6.9, "https://open.spotify.com/track/3ETUDzHZP3Ue3C767F9jxM?si=b2f5fe358f544165", "it's so relaxing");
        songStorage.saveSong(song103);
        Song song104 = new Song(album8, "PPP", 386, 8.5, "https://open.spotify.com/track/5JyJsAZyLTD7W5oWLeB0JK?si=a3d40694c7c34d64", "this song is so pretty");
        songStorage.saveSong(song104);
        Song song105 = new Song(album8, "Wildflower", 219, 9.8, "https://open.spotify.com/track/24bzJwjGBWtGCs7xKIKQsB?si=60a900f4dd63406d", "soooo good");
        songStorage.saveSong(song105);
        Song song106 = new Song(album8, "Bluebird", 235, 9.4, "https://open.spotify.com/track/2ZwToUy7ZKvBBN2ik7kK0p?si=0017eadad4a94f19", "love how soft and sweet this is");
        songStorage.saveSong(song106);
        Song song107 = new Song(album8, "Days Of Candy", 375, 9.6, "https://open.spotify.com/track/6Jzr32geft80FJxOPGr4uw?si=86fde12e20664cfb", "immaculate vibes");
        songStorage.saveSong(song107);
    }
}