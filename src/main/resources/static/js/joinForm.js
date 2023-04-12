let pwd_flag = 0;
let isok_flag = 0;

const passwordInput = document.getElementById("password");
const confirmPasswordInput = document.getElementById("password_confirm");
const message = document.getElementById("pwd_message");
const ok_message = document.getElementById("password_isok");
const enablebutton = document.getElementById("button_en");

confirmPasswordInput.addEventListener("keyup", () => {
    const password = passwordInput.value;
    const confirmPassword = confirmPasswordInput.value;
    if (password && confirmPassword && password === confirmPassword && isok_flag) {
        message.style.color = "blue";
        message.textContent = "비밀번호가 같습니다.";
        enablebutton.disabled = false;
    }
    else if (password && confirmPassword && password != confirmPassword && isok_flag) {
        message.style.color = "red";
        message.textContent = "비밀번호가 다릅니다.";
        enablebutton.disabled = true;
    }
});
passwordInput.addEventListener("keyup", () => {
    const password = passwordInput.value;
    const confirmPassword = confirmPasswordInput.value;
    if (password.length < 6) {
        isok_flag = 0;
        ok_message.style.color = "red";
        ok_message.textContent = "비밀번호는 최소 6자 이상이여야 합니다.";
        enablebutton.disabled = true;
    }
    else if (!/[a-z]/.test(password) || !/[0-9]/.test(password)) {
        isok_flag = 0;
        ok_message.style.color = "red";
        ok_message.textContent = "비밀번호는 영문자, 숫자를 모두 포함해야 합니다.";
        enablebutton.disabled = true;
    }
    else {
        isok_flag = 1;
        ok_message.textContent = "";
    }
    if (password && confirmPassword && password === confirmPassword && isok_flag) {
        pwd_flag = 1;
        message.style.color = "blue";
        message.textContent = "비밀번호가 같습니다.";
        enablebutton.disabled = false;
    }
    else if (password && confirmPassword && password != confirmPassword && pwd_flag) {
        pwd_flag = 0;
        message.style.color = "red";
        message.textContent = "비밀번호가 다릅니다.";
        enablebutton.disabled = true;
    }
});

