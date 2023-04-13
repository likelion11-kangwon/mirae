let fan_names = "김이박최강고윤엄한배성백전황서천방지마피".split("");
let first_names = "건성현욱정민현주희진영래주동혜도모영진선재현호시우인성마무병별솔하라".split("");
let alphas = ("abcdfghijklmnopqrtuvwxyz".repeat(3)).split("");
let nums = ("0123456789".repeat(4)).split("");

let year1 = []
let year2 = []
for(let i = 1; i < 6; i++){
    year1.push(i);
}
for(let i = 95; i <= 99; i++){
    year2.push(i);
}

let years = year1.concat(year2).concat(0);


let addrs = ['서울', '대전', '부산', '대구', '진접', '제주', '울산', '광주', '춘천', '강릉', '원주', '파주', '시흥', '퇴계원', '마포', '강남', '잠실', '인천', '전주', '덕소', '독도', '영국', '미국', '중국', '일본', '대만', '홍콩', '가나', '경주', '장흥', '설악산', '백두산', '워싱턴', '런던', '뉴욕', '홍대', '명동'];

let monthes = [];
for(let i = 1; i <= 12; i++){
    monthes.push(i);
}

let m30 = [4, 6, 9, 11];
let days = [];
let days30 = [];
let days28 = [];

for(let i = 1; i <= 31; i++){
    days.push(i);
    if(i <= 30){
        days30.push(i);
    }
    if(i <= 28){
        days28.push(i);
    }
}


function make_birth() {
    let y = randomChoice(years);
    let m = randomChoice(monthes);
    let d = randomChoice(days);

    if (m in m30 && d > 30) {
        d = randomChoice(days30);
    }
    if (m === 2 && d > 28) {
        d = randomChoice(days28);
    }

    return `${y.toString().padStart(2, "0")}${m.toString().padStart(2, "0")}${d.toString().padStart(2, "0")}`;
}


function nr(n = 4) {
    return nums.sort(() => Math.random() - Math.random()).slice(0, n).join("");
}

function ar(n = 5) {
    return alphas.sort(() => Math.random() - Math.random()).slice(0, n).join("");
}


function make_MBTI() {
    let first = Math.random() < 0.5 ? 'E' : 'I';
    let second = Math.random() < 0.5 ? 'S' : 'N';
    let third = Math.random() < 0.5 ? 'T' : 'F';
    let fourth = Math.random() < 0.5 ? 'J' : 'P';
    return (first + second + third + fourth);
}

function make_data() {
    let sung = randomChoice(fan_names);
    let name = randomChoice(first_names);
    let compare = randomChoice(first_names);
    while(name == compare){
        compare = randomChoice(first_names);
    }
    name = name + compare;

    let MBTI = make_MBTI();
    let email = `${ar(randomInt(3, 9))}@gmail.com`;
    let birth = make_birth();
    let addr = randomChoice(addrs);

    return [sung + name, email, MBTI, birth, addr];
}

// let data = [];
// for (let i = 0; i < 10; i++) {
//   data.push(make_data());
// }

console.log(make_data());

function randomChoice(arr) {
    return arr[Math.floor(Math.random() * arr.length)];
}

function randomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1) + min);
}


/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////



function showCode() {
    const codeDiv = document.getElementById("code");
    const codebutton = document.getElementById("code_button");
    codebutton.style.display = "none";
    codeDiv.innerHTML = "<div class='loading'> \
	<span>L</span> \
	<span>O</span> \
	<span>A</span> \
	<span>D</span> \
	<span>I</span> \
	<span>N</span> \
	<span>G</span> \
  </div>";
    setTimeout(function() {
        let arr = make_data();
        codebutton.style.display = "block";
        codebutton.style.marginLeft = "auto";
        codebutton.style.marginRight = "auto";
        codebutton.style.marginBottom = "10px";

        codeDiv.innerHTML = "<span class='couple'> 내 이름은 " + arr[0] + "! </span>" +
            "<span class='couple'> 내 MBTI는 " + arr[2] + " 야</span>" +
            "<p class='couple'> 나는 " + arr[3][0] + arr[3][1] +"년생 "+ arr[3][2] + arr[3][3] +"월 "+ arr[3][4]+ arr[3][5] +"일생이고 " +
            arr[4] + "에 살고있어</p>" +
            "<p class='couple'> 여기로 연락해 !  " + arr[1] + "</p>";
    }, 2500);
}

