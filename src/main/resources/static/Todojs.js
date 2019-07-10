var toimet = [];
hae();

function hae(){
    axios.get("/api/todot")
        .then(function (response) {
        toimet = response.data;
        kirjoita(toimet);
            console.log(response);
        })
        .catch(function (error) {
            console.log(error);
        })
        .finally(function () {

        });
}

function poista(t) {
    axios.delete('/api/todot/'+t)
        .finally(function(){
        hae()
    });

    }


function lisaa (e){
    //e.preventDefault();
    var uusitehtava = document.getElementById("uusi").value;
    axios.post('/api/todot', {
        tehtava: uusitehtava
    })
        .then(function (response) {
            console.log(response);
        })
        .catch(function (error) {
            console.log(error)
        }).finally(function(){
        hae();
    });

}


function kirjoita(){
    var tehtavat = document.getElementById("tehtavat");
    tehtavat.innerHTML = "<tr><td></td></tr>"
    for(t of toimet){
        console.log(t.id)
    tehtavat.innerHTML += "<tr><td>"+t.tehtava+"</td><td><button onclick='poista("+t.id+")'>Poista</button></td></tr>"}

}