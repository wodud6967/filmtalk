async function getSeats() {
    // 나중에 session값 hidden으로 숨겨서 가져오기
    let showtimeId = 2; // showtime 2번

    // fetch 요청하기
    let response = await fetch(`/seat/` + showtimeId, {
        method: "get",

    });
    let responseBody = await response.json();
    if (response.ok) {
        renderSeats(responseBody);
    } else {
        alert("좌석 정보를 불러 올 수 없습니다.");
    }

}

let selectedSeats = []; // 선택된 좌석을 저장할 배열

// 좌석 렌더링
function renderSeats(responseBody) {
    const totalColumn = responseBody.totalColumn; // 총 열 갯수
    const seats = responseBody.seats; // 좌석 정보 담은 리스트
    const reservedSeats = responseBody.reservedSeats; // 예약된 좌석 정보 담은 리스트

    // 좌석이 들어갈 HTML 요소를 선택
    const seatContainer = document.getElementById("seat-container");
    seatContainer.innerHTML = ''; // 기존 좌석 레이아웃 초기화

    let currentRow = ''; // 현재 줄을 추적
    let rowElement; // 현재 줄의 요소


    // 좌석 렌더링
    seats.forEach(seatInfo => {
        // row가 바뀌면 새로운 줄을 만든다
        if (seatInfo.row !== currentRow) { // A '' -> A // B A -> B
            currentRow = seatInfo.row; // currentRow = A
            rowElement = document.createElement('div'); // row div 만들기
            rowElement.className = 'seat-row'; // div class = "seat-row"
            seatContainer.appendChild(rowElement); // div 생성!
        }

        // 예약 여부
        // reservedSeats의 row와 넘어온 SeatInfo의 row가 같고, reservedSeats의 col과 seatInfo의 col이 같으면
        // 예약된 좌석이니까
        // true 가 반환된다.
        // some은 JavaScript의 배열 메서드 중 하나로, 배열의 요소 중에서 주어진 조건을 만족하는 요소가 하나라도 있는지 확인할 때 사용
        const isReserved = reservedSeats.some(rs => rs.row === seatInfo.row && rs.col === seatInfo.col);

        // 좌석을 표시하는 버튼 생성
        let seatButton = document.createElement('button'); // button 선언
        seatButton.className = 'seat'; // 버튼의 calss명은은 seat
        seatButton.textContent = seatInfo.row + seatInfo.col; // A + 1
        seatButton.id = 'seat-' + seatInfo.id; // seat + pk

        if (isReserved) { // TRUE
            seatButton.classList.add('reserved');
            seatButton.disabled = true; // 예약된 좌석은 클릭 불가
        } else {
            seatButton.classList.add('available'); // 예약안된 좌석은 Class 이름에 available 추가
            let isSelected = false; // 지금은 선택 안되어있으니 false


            seatButton.addEventListener('click', function () { // 클라이언트가 클릭을 시작..!

                isSelected = seatButton.classList.contains('selected'); // 버튼의 현재 선택 상태 확인

                if (isSelected) {
                    seatButton.style.backgroundColor = ''; // 선택 해제 시 원래 색으로 돌아옴
                    seatButton.classList.remove('selected');
                    selectedCount--;

                    // 선택 해제 시 선택된 좌석에서 제거
                    selectedSeats = selectedSeats.filter(seat => seat !== seatButton.textContent);
                } else {
                    if (selectedCount < maxSelectableSeats) { // 선택 가능한 좌석 수 체크
                        // 선택할 때마다 배열을 새로 구성
                        seatButton.style.backgroundColor = 'red'; // 선택 시 빨간색으로 변경
                        seatButton.classList.remove('available');
                        seatButton.classList.add('selected');

                        selectedCount++; // 선택된 좌석 수 증가
                        selectedSeats.push(seatButton.textContent); // 선택된 좌석을 배열에 추가
                        console.log(selectedSeats);
                        /*
                                                // selected 클래스를 포함하고 있을 때 해당 seatButton의 textContent를 출력
                                                if(seatButton.classList.contains('selected')){
                                                    console.log(seatButton.textContent);
                                                }
                        */

                        if (selectedCount === maxSelectableSeats) {
                            // // 더 이상 좌석을 선택할 수 없을 때 나머지 좌석을 비활성화
                            // document.querySelectorAll('.seat.available').forEach(seat => {
                            //     if (!seat.classList.contains('selected')) {
                            //         seat.disabled = true; // 나머지 좌석 비활성화
                            //         seat.style.backgroundColor = '#ccc'; // 비활성화된 좌석의 배경색 진하게 변경
                            //     }
                            // });
                            // seatNumbers 함수를 통해 선택된 좌석 번호를 추가
                            document.getElementById("seatNumBox").innerHTML = ''; // 기존 내용 초기화

                            // 선택된 좌석들을 HTML로 변환하여 추가
                            document.getElementById("seatNumBox").innerHTML = `
                                    <table class="seatNumTable">
                                        <tr>
                                            <th>좌석번호</th>
                                        </tr>
                                        ${selectedSeats.map(seat => `<tr><td>${seat}</td></tr>`).join('')}
                                    </table>`;

                            document.getElementById("selectedSeats").value = selectedSeats.join(','); // 배열을 문자열로 변환

                            let price = selectedCount * 20000;
                            let totalPrice = price.toLocaleString();
                            console.log(totalPrice);
                            document.getElementById("totalPrice").value = totalPrice;


                            document.getElementById("paymentBox").innerHTML = '';
                            document.getElementById("paymentBox").innerHTML = `
                                            <table>
                                                <tr>
                                                    <td>일반</td>
                                                    <td>20,000원 * ${selectedCount}</td>
                                                </tr>
                                                <tr>
                                                    <td>총금액  &nbsp&nbsp</td>
                                                    <td style="color: red">${totalPrice}원</td><!-- 빨간색 -->
                                                </tr>
                            
                                            </table>
                            `;

                        }
                    } else {
                        alert(`최대 ${maxSelectableSeats}개의 좌석만 선택할 수 있습니다.`);
                    }
                }
            });
        }

        rowElement.appendChild(seatButton); // 버튼을 현재 줄에 추가
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

function toPayment(){



}