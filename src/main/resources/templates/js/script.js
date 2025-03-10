// Функция для получения данных с сервера
async function fetchData() {
    try {
        const response = await fetch('http://localhost:8080/get');
        if (!response.ok) {
            throw new Error('Ошибка при запросе данных');
        }
        const data = await response.json(); // Предполагаем, что сервер возвращает JSON
        updatePage(data); // Обновляем страницу данными
    } catch (error) {
        console.error('Ошибка:', error);
    }
}

// Функция для обновления элементов страницы
function updatePage(data) {


    // Вставляем данные в соответствующие элементы
    document.getElementById('card-image').src = data.img;
    document.getElementById('card-title').textContent = data.title;
    document.getElementById('card-price').textContent = `Цена: ${data.price}`;
    document.getElementById('card-city').textContent = `Город: ${data.city}`;
    document.getElementById('card-id').textContent = `ID: ${data.id}`;
}

// Запускаем функцию при загрузке страницы
fetchData();