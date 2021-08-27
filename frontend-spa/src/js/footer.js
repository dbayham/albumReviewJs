import {
    displayHomeView
} from "./displayHomeView.js";
import {
    clearChildren
} from "./displayAlbum.js";

const createFooter = function(){
    const mainElement = document.querySelector(".main-content");

    const footer = document.createElement("footer");
    footer.classList.add("main-footer");

    const copywrite = document.createElement("div");
    copywrite.classList.add("copywrite");
    copywrite.innerHTML = '<small class="main-footer__copywrite">Maggots &copy;2021</small>'

    const homeButton = document.createElement("button");
    homeButton.classList.add("footer-home-button");
    homeButton.setAttribute("type" , "button");
    
    homeButton.addEventListener("click", () => {
        clearChildren(mainElement);
        fetch("http://localhost:8080/api/albums")
            .then(response => response.json())
            .then(albums => displayHomeView(albums))
            .catch(error => console.log(error));
        console.log("Clicked footer home button");
    })

    const albumTitleInput = document.createElement("input");
    albumTitleInput.classList.add("new-album-title");
    albumTitleInput.setAttribute("type", "text");
    albumTitleInput.setAttribute("placeholder", "Title");

    const albumImageInput = document.createElement("input");
    albumImageInput.classList.add("new-album-imageUrl");
    albumImageInput.setAttribute("type", "text");
    albumImageInput.setAttribute("placeholder", "Image Url");

    const albumArtistInput = document.createElement("input");
    albumArtistInput.classList.add("new-album-artist");
    albumArtistInput.setAttribute("type", "text");
    albumArtistInput.setAttribute("placeholder", "Artist");

    const albumRecordLabelInput = document.createElement("input");
    albumRecordLabelInput.classList.add("new-album-recordLabel");
    albumRecordLabelInput.setAttribute("type", "text");
    albumRecordLabelInput.setAttribute("placeholder", "Record Label");

    const albumRatingInput = document.createElement("input");
    albumRatingInput.classList.add("new-album-rating");
    albumRatingInput.setAttribute("type", "number");
    albumRatingInput.setAttribute("placeholder", "Rating");
    albumRatingInput.setAttribute("min", "1");
    albumRatingInput.setAttribute("max", "10");

    const submitAlbumButton = document.createElement("button");
    submitAlbumButton.classList.add("submit-album");
    submitAlbumButton.innerText = "Submit New Album";
    const formattingElement = document.createElement("div");
    formattingElement.innerHTML = "<br><hr><br>";

    submitAlbumButton.addEventListener("click", (clickEvent) => {
        clickEvent.preventDefault();
        clearChildren(mainElement);
        const albumJson = {
            title: albumTitleInput.value,
            imageUrl: albumImageInput.value,
            artist: albumArtistInput.value,
            recordLabel: albumRecordLabelInput.value,
            rating: albumRatingInput.value,
        };

        fetch("http://localhost:8080/api/albums", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(albumJson),
            })
            .then((response) => response.json())
            .then((albums) => displayHomeView(albums, mainElement))
            .catch((error) => console.log(error));
    });
    let addAlbumButton = document.createElement("button");
    addAlbumButton.classList.add("add-album-button");
    addAlbumButton.setAttribute("type", "button");

    let addAlbumModal = document.createElement("div");
    addAlbumModal.classList.add("modal");

    let addAlbumModalBox = document.createElement("div");
    addAlbumModalBox.classList.add("modal-content");

    let close = document.createElement("span");
    close.classList.add("close");
    close.innerHTML = "&times;";

    addAlbumButton.onclick = function() {
        addAlbumModal.style.display = "block";
    }

    close.onclick = function() {
        addAlbumModal.style.display = "none";
    }

    addAlbumModalBox.appendChild(albumTitleInput);
    addAlbumModalBox.appendChild(albumImageInput);
    addAlbumModalBox.appendChild(albumArtistInput);
    addAlbumModalBox.appendChild(albumRecordLabelInput);
    addAlbumModalBox.appendChild(albumRatingInput);
    addAlbumModalBox.appendChild(submitAlbumButton);
    addAlbumModalBox.appendChild(close);

    addAlbumModal.appendChild(addAlbumModalBox)
    footer.appendChild(addAlbumModal);
    footer.appendChild(addAlbumButton);
    footer.appendChild(homeButton);
    footer.appendChild(copywrite);
    return footer;
}

export{createFooter}