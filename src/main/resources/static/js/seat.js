async function getSeats(){
    // 나중에 session값 hidden으로 숨겨서 가져오기
    let showtimeId = 2;

    // fetch 요청하기
    let response = await fetch(`/seat/` + showtimeId, {
        method: "get",

    });
    let responseBody = await response.json();
    if(response.ok){
        renderSeats(responseBody.body.seats);
    }else{
        alert("좌석 정보를 불러 올 수 없습니다.");
    }

}

function renderSeats(seats){

    //SET을 사용하여 행의 고유한 값만 저장
    let rowSet = new Set();
    let maxCols = 0;

    seats.forEach(seat => {
        // row를 Set에 추가 (중복된 값은 Set에 추가되지 않음)
        rowSet.add(seat.row);
    });

    // 각 row에 대해 최대 열(col)의 개수를 찾기 위해 그룹화
    let rowGroups = {};
    seats.forEach(seat => {
        // 각 row 별로 배열에 col을 저장
        if (!rowGroups[seat.row]) {
            rowGroups[seat.row] = [];
        }
        rowGroups[seat.row].push(seat.col);
    });

    // 각 row에서 열의 개수를 확인하여 최대 열 수 계산
    Object.keys(rowGroups).forEach(row => {
        if (rowGroups[row].length > maxCols) {
            maxCols = rowGroups[row].length;
        }
    });


    const rows = rowSet.size;  // 행의 수 // 2
    const columns = maxCols;  // 열의 수 // 4

    let seatLayout = [];

    // 좌석 배열 생성
    for (let i = 0; i < rows; i++) {

        let row = [];
        for (let j = 0; j < columns; j++) {
            if (aisleColumns.includes(j)) {
                row.push('aisle');  // 통로를 'aisle'로 표시
            } else {
                let object = seats[i];
                console.log(object.col);
                console.log(object.row);
                row.push(object[i].row + object[i].col);  // 좌석 번호를 R1C1, R1C2 등으로 표시
            }
        }
        seatLayout.push(row);
    }

// 좌석 및 통로 렌더링
    seatLayout.forEach(row => {
        if (row === 'horizontal-aisle') {
            let aisleDiv = document.createElement('div');
            aisleDiv.classList.add('horizontal-aisle');
            document.getElementById('seat-container').appendChild(aisleDiv);
        } else {
            let rowDiv = document.createElement('div');
            rowDiv.classList.add('row');

            row.forEach(seat => {
                let seatDiv = document.createElement('div');
                seatDiv.classList.add(seat === 'aisle' ? 'aisle' : 'seat');
                seatDiv.textContent = seat === 'aisle' ? '' : seat;
                rowDiv.appendChild(seatDiv);
            });

            document.getElementById('seat-container').appendChild(rowDiv);
        }
    });

    // let seatContainer = document.getElementById('seat-container');
    // seatContainer.innerHTML = ''; // 기존 좌석 정보 지우기
    //
    // let currentRow = ''; // 현재 행 저장
    // let rowDiv = null; // 현재 row의 div
    //
    // seats.forEach(seat => {
    //     // 새로운 row일 때 새 줄(rowDiv) 추가
    //     if (seat.row !== currentRow) {
    //         currentRow = seat.row; // 현재 row 업데이트
    //         rowDiv = document.createElement('div'); // 새로운 row의 div 생성
    //         rowDiv.classList.add('seat-row'); // 줄을 구분할 수 있는 클래스 추가
    //         seatContainer.appendChild(rowDiv); // 컨테이너에 줄 추가
    //     }
    //
    //     // 좌석을 현재 rowDiv에 추가
    //     let seatElement = document.createElement('span');
    //     seatElement.classList.add('seat'); // 좌석을 구분할 수 있는 클래스 추가
    //     seatElement.innerText = `${seat.row}${seat.col}`; // 좌석 번호 (예: A2, A3 등)
    //     rowDiv.appendChild(seatElement); // 현재 rowDiv에 좌석 추가
    // });
}

//함수 실행시키기
getSeats();

const rows = 10;  // 행의 수
const columns = 12;  // 열의 수
const aisleColumns = [4, 9];  // 통로가 들어갈 열 번호
const horizontalAisleRow = 5;  // 통로가 들어갈 행 번호

let seatLayout = [];

// 좌석 배열 생성
for (let i = 0; i < rows; i++) {
    if (i === horizontalAisleRow) {
        seatLayout.push('horizontal-aisle'); // 가로 통로 추가
    }

    let row = [];
    for (let j = 0; j < columns; j++) {
        if (aisleColumns.includes(j)) {
            row.push('aisle');  // 통로를 'aisle'로 표시
        } else {
            row.push(`${i + 1}${j + 1}`);  // 좌석 번호를 R1C1, R1C2 등으로 표시
        }
    }
    seatLayout.push(row);
}

// 좌석 및 통로 렌더링
seatLayout.forEach(row => {
    if (row === 'horizontal-aisle') {
        let aisleDiv = document.createElement('div');
        aisleDiv.classList.add('horizontal-aisle');
        document.getElementById('seat-container').appendChild(aisleDiv);
    } else {
        let rowDiv = document.createElement('div');
        rowDiv.classList.add('row');

        row.forEach(seat => {
            let seatDiv = document.createElement('div');
            seatDiv.classList.add(seat === 'aisle' ? 'aisle' : 'seat');
            seatDiv.textContent = seat === 'aisle' ? '' : seat;
            rowDiv.appendChild(seatDiv);
        });

        document.getElementById('seat-container').appendChild(rowDiv);
    }
});

// 일반 버튼 선택 시 value 가져오기
// 선택한 value 만큼 좌석 선택 가능


// 선택한 value 만큼 좌석 선택하고 나면
// 1. 더이상 좌석 선택 못하게 막기
// 2. 동시에 하단 검은창에 선택한 좌석 번호랑 선택한 좌석의 갯수 및 해당 좌석의 가격(showtime에 있음) 띄우기
// 연산해서 총금액까지

// 결제선택을 누르는 순간
// reservation insert하고나서 ticket insert 하고나서
// session에 reservation id 담아서 보내기
