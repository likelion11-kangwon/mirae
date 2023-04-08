function githubRank() {
    fetch('/mirae/api/commit_rank').then(function (response) {
        // console.log('success!', response);
        response.json().then(function (data) {
            if (data.length > 0) {
                const sortedData = data.sort((a, b) => {
                    if (a['commits'] > b['commits']) {
                        return -1;
                    }
                });
                document.querySelector('div.commit_rank_content').innerHTML = ""
                sortedData.slice(0, 3).forEach((githubUser, index) => {
                    document.querySelector('div.commit_rank_content').innerHTML += `
                                <div class="github_content_group">
                                <img src="${githubUser['avatar']}" />
                                <a class="github_name me-auto" href="https://github.com/${githubUser['login']}">${githubUser['username']}</a>
                        <span class="github_commits">${githubUser['commits']}</span>
                        <span class="github_rank">(&#12935${index + 1};)</span>
                    </div>`
                });
                document.querySelector('div.commit_rank_content').innerHTML += `<hr class="hr hr-blurry" />`
                const myGithubInfo = sortedData.find(e => e['login'] == "gunyu1019")
                document.querySelector('div.commit_rank_content').innerHTML += `
                                <div class="github_content_group">
                                <img src="${myGithubInfo['avatar']}" />
                                <a class="github_name me-auto" href="https://github.com/${myGithubInfo['login']}">${myGithubInfo['username']}</a>
                        <span class="github_commits">${myGithubInfo['commits']}</span>
                    `
            } else {
                document.querySelector('div.commit_rank_content').innerHTML = `
                        <div class="commit_rank_text">
                            <span>&#009888; Something Wrong</span>
                        </div>`
            }
        })
    }).catch(function (_) {
        // console.warn('Something went wrong.', err);
        document.querySelector('div.commit_rank_content').innerHTML = `
                        <div class="commit_rank_text">
                            <span>&#009888; Failed</span>
                        </div>`
    });
}