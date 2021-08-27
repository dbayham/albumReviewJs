import {
    displayHomeView
} from "./displayHomeView.js";
import {
    secondsToHms
} from "./secondsToMinutesFormat.js";

const displaySingleAlbum = function(album, albums) {
    const mainElement = document.querySelector(".main-content");
    clearChildren(mainElement);

    const sAlbumContainer = document.createElement("main");
    sAlbumContainer.classList.add("container");

    const albumDetails = document.createElement("div");
    albumDetails.classList.add("sa-album-details");

    const albumImage = document.createElement("img");
    albumImage.classList.add("sa-album-image");
    albumImage.src = album.imageUrl;

    const albumArtist = document.createElement("p");
    albumArtist.classList.add("sa-artist_name");
    albumArtist.innerText = album.artist;

    const albumTitle = document.createElement("p");
    albumTitle.classList.add("sa-album-title");
    albumTitle.innerText = album.title;

    const albumRating = document.createElement("p");
    albumRating.classList.add("sa-rating");
    albumRating.innerText = album.rating;

    const deleteAlbumButton = document.createElement("button");
    deleteAlbumButton.innerText = "Delete Album";

    deleteAlbumButton.addEventListener("click", () => {
        clearChildren(mainElement);
        fetch("http://localhost:8080/api/albums/" + album.id, {
                method: "DELETE",
            })
            .then((response) => response.json())
            .then((albums) => displayHomeView(albums))
            .catch((error) => console.log(error));
    });

    const songSection = document.createElement("p");
    songSection.classList.add("sa-album-songs");

    const albumComments = document.createElement("p");
    albumComments.classList.add("sa-comments");
    if (album.comments != null) {
        album.comments.forEach((comment) => {
            const li = document.createElement("li");
            li.innerText = comment;
            albumComments.appendChild(li);
        });
    }

    if (album.songs != null) {
        album.songs.forEach((song) => {
            const songElement = document.createElement("div");
            songElement.classList.add("song-features");

            const songTitle = document.createElement("div");
            songTitle.classList.add("song-title");
            songTitle.innerText = song.title;



            const songInfoButton = document.createElement("button")
            songInfoButton.classList.add("song-info-button");
            songInfoButton.setAttribute("type", "button");

            songInfoButton.onclick = function() {
                songModal.style.display = "block";
            }

            let songModal = document.createElement("div");
            songModal.classList.add("modal");

            let songModalBox = document.createElement("div");
            songModalBox.classList.add("modal-content");

            let close = document.createElement("span");
            close.classList.add("close");
            close.innerHTML = "&times;";

            close.onclick = function() {
                songModal.style.display = "none";
            }
            const songDuration = document.createElement("div");
            songDuration.classList.add("song-duration");
            songDuration.innerText = "Duration: " + secondsToHms(song.duration);

            const songRating = document.createElement("div");
            songRating.classList.add("song-rating");
            songRating.innerText = "Rating: " + song.rating;

            const songLink = document.createElement("a");
            songLink.classList.add("song-link");
            songLink.href = song.linkURL;
            songLink.innerText = "Click here to play " + song.title;

            const songCommentsHeader = document.createElement("div");
            songCommentsHeader.classList.add("song-comments-header");
            songCommentsHeader.innerText = "Comments"

            const songComments = document.createElement("ul");
            songComments.classList.add("song-comments");
            if (song.comments == null) {
                song.comments = "";
            } else {
                song.comments.forEach((comment) => {
                    const li = document.createElement("li");
                    li.innerText = comment;
                    songComments.appendChild(li);
                });
            }

            const deleteButton = document.createElement("button");
            deleteButton.classList.add("delete-button")
            deleteButton.innerText = "Delete Song";

            const newSongCommentForm = document.createElement("form");
            newSongCommentForm.innerHTML = ` 
              <input class="song-comment-input" placeholder="New Comment" type="text">
              <button class="submit-new-song-comment">Submit New Comment</button>`;

            const changeSongRatingForm = document.createElement("form");
            changeSongRatingForm.innerHTML = `
              <input class="song-rating-input" placeholder="New Rating" type="number">
              <button class="submit-song-rating">Change Rating</button>`;

            songModalBox.appendChild(songLink);
            songModalBox.appendChild(songDuration);
            songModalBox.appendChild(songRating);
            songModalBox.appendChild(changeSongRatingForm);
            songModalBox.appendChild(songCommentsHeader);
            songModalBox.appendChild(songComments);
            songModalBox.appendChild(newSongCommentForm);
            songModalBox.appendChild(deleteButton);
            songModalBox.appendChild(close);

            songModal.appendChild(songModalBox);
            songElement.appendChild(songModal);
            songElement.appendChild(songTitle);
            songElement.appendChild(songInfoButton);
            songSection.appendChild(songElement);

            deleteButton.addEventListener("click", () => {
                fetch(
                        "http://localhost:8080/api/albums/" + album.id + "/songs/" + song.id, {
                            method: "DELETE",
                        }
                    )
                    .then((response) => response.json())
                    .then((album) => displaySingleAlbum(album, albums))
                    .catch((error) => console.log(error));
            });

            changeSongRatingForm
                .querySelector(".submit-song-rating")
                .addEventListener("click", (clickEvent) => {
                    clickEvent.preventDefault();
                    clearChildren(mainElement);

                    fetch(
                            "http://localhost:8080/api/albums/" +
                            album.id +
                            "/songs/" +
                            song.id +
                            "/rating", {
                                method: "PUT",
                                headers: {
                                    "Content-Type": "application/json",
                                },
                                body: changeSongRatingForm.querySelector(".song-rating-input")
                                    .value,
                            }
                        )
                        .then((response) => response.json())
                        .then((album) => displaySingleAlbum(album))
                        .catch((error) => console.log(error));
                });

            newSongCommentForm
                .querySelector(".submit-new-song-comment")
                .addEventListener("click", (clickEvent) => {
                    clickEvent.preventDefault();
                    clearChildren(mainElement);

                    fetch(
                            "http://localhost:8080/api/albums/" +
                            album.id +
                            "/songs/" +
                            song.id +
                            "/comments", {
                                method: "PATCH",

                                body: newSongCommentForm.querySelector(".song-comment-input")
                                    .value,
                            }
                        )
                        .then((response) => response.json())
                        .then((album) => displaySingleAlbum(album))
                        .catch((error) => console.log(error));
                });
        });
    }

    const albumRecordLabel = document.createElement("p");
    albumRecordLabel.classList.add("sa-record-label");
    albumRecordLabel.innerText = album.recordLabel;

    let addSongButton = document.createElement("button");
    addSongButton.classList.add("add-song-button");
    addSongButton.setAttribute("type", "button");

    let addSongModal = document.createElement("div");
    addSongModal.classList.add("modal");

    let addSongModalBox = document.createElement("div");
    addSongModalBox.classList.add("modal-content");

    let close = document.createElement("span");
    close.classList.add("close");
    close.innerHTML = "&times;";

    addSongButton.onclick = function() {
        addSongModal.style.display = "block";
    }

    close.onclick = function() {
        addSongModal.style.display = "none";
    }

    const songTitleInput = document.createElement("input");
    songTitleInput.classList.add("new-song-title");
    songTitleInput.setAttribute("type", "text");
    songTitleInput.setAttribute("placeholder", "Title");

    const songDurationInput = document.createElement("input");
    songDurationInput.classList.add("new-song-duration");
    songDurationInput.setAttribute("type", "number");
    songDurationInput.setAttribute("placeholder", "Duration");

    const songRatingInput = document.createElement("input");
    songRatingInput.classList.add("new-song-rating");
    songRatingInput.setAttribute("type", "number");
    songRatingInput.setAttribute("placeholder", "Rating");
    songRatingInput.setAttribute("min", "1");
    songRatingInput.setAttribute("max", "10");

    const songLinkInput = document.createElement("input");
    songLinkInput.classList.add("new-song-linkUrl");
    songLinkInput.setAttribute("type", "text");
    songLinkInput.setAttribute("placeholder", "Song Link URL");

    const newSongCommentInput = document.createElement("input");
    newSongCommentInput.classList.add("new-song-comment");
    newSongCommentInput.setAttribute("type", "text");
    newSongCommentInput.setAttribute("placeholder", "Initial Comment");

    const submitSongButton = document.createElement("button");
    submitSongButton.classList.add("submit-new-song");
    submitSongButton.innerText = "Submit New Song";
    const formattingElement = document.createElement("div");
    formattingElement.innerHTML = "<br><hr><br>";

    submitSongButton.addEventListener("click", (clickEvent) => {
        clickEvent.preventDefault();
        clearChildren(mainElement);

        const songJson = {
            title: songTitleInput.value,
            artist: albumArtist.value,
            duration: songDurationInput.value,
            rating: songRatingInput.value,
            linkURL: songLinkInput.value,
            comment: newSongCommentInput.value,
        };
        fetch("http://localhost:8080/api/albums/" + album.id + "/songs", {
                method: "PATCH",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(songJson),
            })
            .then((response) => response.json())
            .then((album) => displaySingleAlbum(album, albums))
            .catch((error) => console.log(error));
    });

    addSongModalBox.appendChild(songTitleInput);
    addSongModalBox.appendChild(songDurationInput);
    addSongModalBox.appendChild(songRatingInput);
    addSongModalBox.appendChild(songLinkInput);
    addSongModalBox.appendChild(newSongCommentInput);
    addSongModalBox.appendChild(submitSongButton);
    addSongModalBox.appendChild(close);
    addSongModal.appendChild(addSongModalBox)
    mainElement.appendChild(addSongModal);
    mainElement.appendChild(addSongButton);

    const newCommentForm = document.createElement("form");
    newCommentForm.innerHTML = ` 
     <input class="comment-input" placeholder="New Comment" type="text">
     <button class="submit-new-comment">Submit New Comment</button>
     `;

    newCommentForm
        .querySelector(".submit-new-comment")
        .addEventListener("click", (clickEvent) => {
            clickEvent.preventDefault();
            clearChildren(mainElement);

            fetch("http://localhost:8080/api/albums/" + album.id + "/comments", {
                    method: "PATCH",

                    body: newCommentForm.querySelector(".comment-input").value,
                })
                .then((response) => response.json())
                .then((album) => displaySingleAlbum(album))
                .catch((error) => console.log(error));
        });

    const changeRatingForm = document.createElement("form");
    changeRatingForm.innerHTML = `
     <input class="rating-input" placeholder="rating" type="number">
     <button class="change-rating">Change Album Rating</button>
     `;
    changeRatingForm.querySelector(".change-rating").addEventListener("click", (clickEvent) => {
        clickEvent.preventDefault();
        clearChildren(mainElement);

        fetch("http://localhost:8080/api/albums/" + album.id + "/rating", {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: changeRatingForm.querySelector(".rating-input").value,
            })
            .then((response) => response.json())
            .then((album) => displaySingleAlbum(album))
            .catch((error) => console.log(error));
    });


    albumDetails.appendChild(albumTitle);
    albumDetails.appendChild(albumRating);
    albumDetails.appendChild(changeRatingForm);
    albumDetails.appendChild(songSection);
    albumDetails.appendChild(albumRecordLabel);
    albumDetails.appendChild(albumComments);
    albumDetails.appendChild(newCommentForm);
    albumDetails.appendChild(deleteAlbumButton);
    sAlbumContainer.appendChild(albumImage);
    sAlbumContainer.appendChild(albumDetails);
    mainElement.appendChild(sAlbumContainer);
};

const clearChildren = function(element) {
    while (element.firstChild) {
        element.removeChild(element.lastChild);
    }
};

export {
    displaySingleAlbum,
    clearChildren
};