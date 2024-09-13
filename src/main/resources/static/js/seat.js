const rows = 10;  // 행의 수
const columns = 12;  // 열의 수
const aisleColumns = [4, 9];  // 통로가 들어갈 열 번호
const horizontalAisleRow = 5;  // 통로가 들어갈 행 번호

let seatLayout = [];

// 좌석 배열 생
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

function getNum(value){
    console.log("You clicked on value:", value);
    // 여기에서 원하는 동작을 추가하세요
    alert("Selected value: " + value);
    //console.log(document.getElementById("count1").value);

}
// 선택한 value 만큼 좌석 선택하고 나면
// 1. 더이상 좌석 선택 못하게 막기
// 2. 동시에 하단 검은창에 선택한 좌석 번호랑 선택한 좌석의 갯수 및 해당 좌석의 가격(showtime에 있음) 띄우기
// 연산해서 총금액까지

// 결제선택을 누르는 순간
// reservation insert하고나서 ticket insert 하고나서
// session에 reservation id 담아서 보내기
