$(document).ready(function () {
    $("span#firework_hover, div.firework").hover(function () {
        $("div.firework").show();
    }, function () {
        $("div.firework").hide();
    })
})