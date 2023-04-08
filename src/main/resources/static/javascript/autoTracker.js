
function autoedTracker(groupContent) {
    const groupWidth = document.querySelector('div.image_group').scrollWidth
    for (let i = 0; i < screen.width * 2; i += groupWidth) {
        document.querySelector('div.image_group').innerHTML += groupContent
    }
}