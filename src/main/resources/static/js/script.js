async function getAllPosts() {
    const result = await fetch('http://localhost:8080/all', {
        method: 'GET',
        headers: {
            'Content-type' : 'Application/json'
        }
    });

    return await result.json();
}

async function sendPost(body) {
    fetch('http://localhost:8080/post', {
        method: 'Post',
        headers: {
            'Content-type' : 'Application/json'
        },
        body: convertFormDataToJson()
    })
}

function convertFormDataToJson() {
    const form = document.querySelector('#send');
    let formData = new FormData(form);
    let obj = {};
    formData.forEach((value, key) => {
        obj[key] = value;
    });

    return JSON.stringify(obj);
}

document.querySelector('#postSend').addEventListener('click', () => {
    sendPost();
});

document.querySelector('#getPosts').addEventListener('click', () => {
    const json = getAllPosts();
    json.then(data => {
        data.forEach(d => {
            postGenerate(d.id, d.title, d.text);
        })
    })
});

function postGenerate(id, title, text) {
    const post = document.createElement('div');
    post.innerHTML = '' +
        '    <div class="post">\n' +
        '        <ul>\n' +
        `            <li>${id}</li>\n `+
        `            <li>${title}</li>\n ` +
        `            <li>${text}</li>\n ` +
        '        </ul>\n' +
        '    </div>';
    document.querySelector('.postContainer').append(post);
}

async function getPostById(id) {
    const result = await fetch(`http://localhost:8080/post/${id}`, {
        method: 'GET',
        headers: {
            'Content-type' : 'Application/json'
        }
    });

    return await result.json();
}

document.querySelector('#getPostsById').addEventListener('click', () => {
    getPostById(1).then(data => {
        console.log(data);
    })
});



