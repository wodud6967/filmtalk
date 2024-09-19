async function getSeats(){
    // 나중에 session값 hidden으로 숨겨서 가져오기
    let showtimeId = 3;

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

function renderSeats(responseBody) {
    const totalColumn = responseBody.totalColumn;
    const seats = responseBody.seats;
    const reservedSeats = responseBody.reservedSeats;

    // 좌석이 들어갈 HTML 요소를 선택
    const seatContainer = document.getElementById("seat-container");
    seatContainer.innerHTML = ''; // 기존 좌석 레이아웃 초기화

    let currentRow = ''; // 현재 줄을 추적
    let rowElement; // 현재 줄의 요소

    // 좌석 렌더링
    seats.forEach(seatInfo => {
        // row가 바뀌면 새로운 줄을 만든다
        if (seatInfo.row !== currentRow) {
            currentRow = seatInfo.row;
            rowElement = document.createElement('div');
            rowElement.className = 'seat-row';
            seatContainer.appendChild(rowElement);
        }

        const isReserved = reservedSeats.some(rs => rs.row === seatInfo.row && rs.col === seatInfo.col);

        // 좌석을 표시하는 버튼 생성
        let seatButton = document.createElement('button');
        seatButton.className = 'seat';
        seatButton.textContent = seatInfo.row + seatInfo.col;

        if (isReserved) {
            seatButton.classList.add('reserved');
            seatButton.disabled = true; // 예약된 좌석은 클릭 불가
        } else {
            seatButton.classList.add('available');
            let isSelected = false;

            seatButton.addEventListener('click', function () {
                if (isSelected) {
                    seatButton.style.backgroundColor = ''; // 선택 해제 시 원래 색으로 돌아옴
                    isSelected = false; // 선택 해제 상태로 변경
                    seatButton.classList.remove('selected');
                    selectedCount--;
                    isSelected = false;
                } else {
                    if (selectedCount < maxSelectableSeats) { // 선택 가능한 좌석 수 체크
                        seatButton.style.backgroundColor = 'red'; // 선택 시 빨간색으로 변경
                        seatButton.classList.add('selected');
                        selectedCount++; // 선택된 좌석 수 증가
                        isSelected = true;

                        if (selectedCount === maxSelectableSeats) {
                            // 더 이상 좌석을 선택할 수 없을 때 나머지 좌석을 비활성화
                            document.querySelectorAll('.seat.available').forEach(seat => {
                                if (!seat.classList.contains('selected')) {
                                    seat.disabled = true; // 나머지 좌석 비활성화
                                    seat.style.backgroundColor = '#ccc'; // 비활성화된 좌석의 배경색 진하게 변경
                                }
                            });
                        }
                    } else {
                        alert(`최대 ${maxSelectableSeats}개의 좌석만 선택할 수 있습니다.`);
                    }
                }
            });
        }

        rowElement.appendChild(seatButton);
    });
}
//함수 실행시키기
getSeats();

let selectedCount = 0; // 현재 선택된 좌석 수
let maxSelectableSeats = 0; // 선택할 수 있는 최대 좌석 수

function getCount(value) {
    maxSelectableSeats = parseInt(value); // 선택할 수 있는 최대 좌석 수를 저장
    selectedCount = 0; // 인원이 변경되면 선택된 좌석을 초기화
    document.querySelectorAll('.seat.selected').forEach(seat => {
        seat.classList.remove('selected');
        seat.style.backgroundColor = ''; // 선택된 좌석을 해제
    });
    console.log(`선택 가능한 좌석 수: ${maxSelectableSeats}`);
}