// 맨 위로 이동 버튼
let moveToTop = function () {
    document.body.scrollIntoView({ behavior: "smooth" });
};


let imgIndex = 0;
let position = 0;
const IMG_WIDTH = 438;
const $btnPrev = document.querySelector(".btn-prev");
const $btnNext = document.querySelector(".btn-next");
const $slideImgs = document.querySelector(".slide-images");

let prev = function () {
    if (imgIndex > 0) {
        $btnNext.removeAttribute("disabled");
        position += IMG_WIDTH;
        $slideImgs.style.transform = `translateX(${position}px)`;
        imgIndex = imgIndex - 1;
    }
    if (imgIndex == 0) {
        $btnPrev.setAttribute("disabled", "true");
    }
};

let next = function () {
    if (imgIndex < 3) {
        $btnPrev.removeAttribute("disabled");
        position -= IMG_WIDTH;
        $slideImgs.style.transform = `translateX(${position}px)`;
        $slideImgs.style.transition = "transform .5s ease-out";
        imgIndex = imgIndex + 1;
    }
    if (imgIndex == 2) {
        $btnNext.setAttribute("disabled", "true");
    }
};

let init = function () {
    $btnPrev.setAttribute("disabled", "true");
    $btnPrev.addEventListener("click", prev);
    $btnNext.addEventListener("click", next);
};

init();


// 모달
const $modalAboutBg = document.getElementsByClassName("modal-background");
const $btnOpen = document.getElementsByClassName("btn-open");
const $btnAboutClose = document.getElementsByClassName("btn-close");

function modalAbout(num) {
    $btnOpen[num].addEventListener("click", () => {
        $modalAboutBg[num].style.display = "flex";
        document.body.style.overflow = "hidden";
    });
    $btnAboutClose[num].addEventListener("click", () => {
        $modalAboutBg[num].style.display = "none";
        document.body.style.overflow = "unset";
    });
}

for (let i = 0; i < $btnOpen.length; i++) {
    modalAbout(i);
}

const $modalBg = document.getElementsByClassName("modal-background-skills");
const $btnOpenSkills = document.getElementsByClassName("btn-open-skills");
const $btnClose = document.getElementsByClassName("btn-close-skills");

function modal(num) {
    $btnOpenSkills[num].addEventListener("click", () => {
        $modalBg[num].style.display = "flex";
        document.body.style.overflow = "hidden";
    });
    $btnClose[num].addEventListener("click", () => {
        $modalBg[num].style.display = "none";
        document.body.style.overflow = "unset";
    });
}

for (let i = 0; i < $btnOpenSkills.length; i++) {
    modal(i);
}

// 스크롤바
let scrollTop = 0;
let bar = document.getElementsByClassName("bar-ing")[0];

window.addEventListener(
    "scroll",
    () => {
        scrollTop = document.documentElement.scrollTop;
        let per = Math.ceil(
            (scrollTop / (document.body.scrollHeight - window.outerHeight)) * 100
        );
        bar.style.width = per + "%";
    },
    false
);



