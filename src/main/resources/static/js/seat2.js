async function getSeats(){
    // 나중에 session값 hidden으로 숨겨서 가져오기
    let showtimeId = 1;

    // fetch 요청하기
    let response = await fetch(`/seat/` + showtimeId, {
        method: "get",

    });
    let responseBody = await response.json();
    if(response.ok){
        renderSeats(responseBody);
    }else{
        alert("좌석 정보를 불러 올 수 없습니다.");
    }

}

function renderSeats(responseBody){

    const totalColumn = responseBody.totalColumn;
    const totalRow = responseBody.totalRow;

    let seatLayout = [];

    for(let i = 0; i < totalRow; i++){
        let row = [];
        for(let j = 0; j < totalColumn; j++){
            row.push(`?`);

        }
    }
    seatLayout.push(row);


}

//함수 실행시키기
getSeats();