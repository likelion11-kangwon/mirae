
function randomChoice(data) {
    return data[Math.floor(Math.random() * data.length)];
}
function travelImageUpdate() {
    document.querySelector("img#activity_image_1").src = `/static/img/yong_hyun/travel/${randomChoice(travelImageFileNameList)}`
}

function gameImageUpdate() {
    document.querySelector("img#activity_image_2").src = `/static/img/yong_hyun/game/${randomChoice(gameImageFileNameList)}`
}

const gameImageFileNameList = [
    "51_Worldwide_Games.png",
    "A_Dance_Fire_And_Ice_1.png",
    "A_Dance_Fire_And_Ice_2.png",
    "A_Dance_Fire_And_Ice_3.jpg",
    "Cities_Skylines.png",
    "Euro_Truck_Simulator.jpg",
    "Factorio_1.png",
    "Factorio_2.png",
    "Fall_Guys.png",
    "Grand_Theif_Auto_1.png",
    "Grand_Theif_Auto_2.png",
    "Oxygen_Not_Included.jpg",
    "PUBG.png",
    "R6.png",
    "Satisfactory.jpg",
    "Satisfactory_2.jpg",
    "Spider_Man.jpg",
    "Spider_Man_DLC.jpg",
    "Spider_Man_Miles_Morales.jpg",
    "Spider_Man_Pizza.jpg",
    "Valorant_1.png",
    "Valorant_2.png",
    "Valorant_3.png"
];

const travelImageFileNameList = [
    "Cheongsong_sunset.jpg",
    "Gangnam_Coex.jpg",
    "Italy_Napoli_2.jpg",
    "Italy_Spain_Stair.jpg",
    "Italy_Venezia.jpg",
    "Italy_Vittorio_Emanuele_II.jpg",
    "Jecheon_Forest_Resom.jpg",
    "Jeju_Seongsanbong.jpg",
    "Jeongseon_High1.jpg",
    "Jeongseon_Najon.jpg",
    "Paris_1.jpg",
    "Paris_2.jpg",
    "Plane.jpg",
    "Singapore.jpg",
    "Sockcho.jpg",
    "Yangpyeong.jpg",
    "Yangyang_Naksansa_1.jpg",
    "Yangyang_Naksansa_2.jpg",
    "Yangyang_Seorak_Mountain_2.jpg",
];
