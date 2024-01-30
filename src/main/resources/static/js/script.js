// モーダルを開くための関数
function openModal() {
    var modal = document.getElementById('myModal');
    modal.style.display = 'block';

    // フェードインのためにクラスを追加
    setTimeout(function () {
        modal.classList.add('show');
    }, 50); // 50ミリ秒の遅延を追加してちょっとしたエフェクトを得る
}

// モーダルを閉じるための関数
function closeModal() {
    var modal = document.getElementById('myModal');
    modal.classList.remove('show');

    // フェードアウト後に非表示にする
    setTimeout(function () {
        modal.style.display = 'none';
    }, 300); // フェードアウト時間よりも長めの遅延を追加
}
// ページが読み込まれたときにモーダルを開くボタンにクリックイベントを追加
document.getElementById('openModalBtn').addEventListener('click', openModal);

// モーダルの閉じるボタンにクリックイベントを追加
document.getElementById('closeModalBtn').addEventListener('click', closeModal);

// モーダルの外側をクリックしても閉じるように
window.addEventListener('click', function (event) {
    if (event.target == document.getElementById('myModal')) {
        closeModal();
    }
});
