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