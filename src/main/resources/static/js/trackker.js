let delay = 300;
let timer = null;

function trackText(trackInnerHtml, size) {
    document.querySelector("div.track").innerHTML = ""
    for (let step = 0; step < screen.width * 2; step += size) {
        document.querySelector("div.track").innerHTML += trackInnerHtml
    }
}

function initTrack(text, size) {
    window.addEventListener('resize', function () {
        clearTimeout(timer);
        document.querySelector("div.track").innerHTML = ""
        timer = setTimeout(function () {
            this.trackText(text, size)
        }, delay);
    })
    window.addEventListener('DOMContentLoaded', function () {
        this.trackText(text, size)
    })
}