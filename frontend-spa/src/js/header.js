const createHeader = function(){
    const header = document.createElement("header");
    header.classList.add("header");
    header.innerHTML = '<span id="maggots">Maggots</span></div><div><span id=album-reviews>Album Reviews</span>';
    return header;
}
export{createHeader}