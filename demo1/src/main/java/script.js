let patients = []; // Локальный массив для хранения загруженных пациентов

// Получение списка пациентов и отображение их на странице
async function getPatients() {
    try {
        const response = await fetch('http://localhost:8080/patients');
        patients = await response.json();
        displayPatients(patients);
    } catch (error) {
        console.error("Ошибка при загрузке пациентов:", error);
    }
}

// Фильтрация пациентов
function filterPatients() {
    const nameFilter = document.getElementById("filter-name").value.toLowerCase();
    const ageFilter = document.getElementById("filter-age").value;
    const genderFilter = document.getElementById("filter-gender").value;

    const filteredPatients = patients.filter(patient => {
        return (
            (!nameFilter || patient.name.toLowerCase().includes(nameFilter)) &&
            (!ageFilter || patient.age == ageFilter) &&
            (!genderFilter || patient.gender === genderFilter)
        );
    });

    displayPatients(filteredPatients);
}

// Отображение списка пациентов
function displayPatients(patientList) {
    let list = document.getElementById("patient-list");
    list.innerHTML = ""; // Очистка списка перед обновлением

    patientList.forEach(patient => {
        let item = document.createElement("li");
        item.innerHTML = `${patient.name}, ${patient.age} лет, Пол: ${patient.gender}, Контакт: ${patient.contactInfo || 'не указан'} 
        <button onclick="deletePatient(${patient.id})">Удалить</button>`;
        list.appendChild(item);
    });
}

// Добавление пациента
async function addPatient(event) {
    event.preventDefault();

    const name = document.getElementById("name").value;
    const age = document.getElementById("age").value;
    const gender = document.getElementById("gender").value;
    const contactInfo = document.getElementById("contactInfo").value;

    const patient = { name, age, gender, contactInfo };

    try {
        const response = await fetch('http://localhost:8080/patients', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(patient)
        });

        if (response.ok) {
            getPatients(); // Обновить список после добавления
        }
    } catch (error) {
        console.error("Ошибка при добавлении пациента:", error);
    }
}

// Удаление пациента
async function deletePatient(id) {
    try {
        await fetch(`http://localhost:8080/patients/${id}`, { method: 'DELETE' });
        getPatients(); // Обновить список после удаления
    } catch (error) {
        console.error("Ошибка при удалении пациента:", error);
    }
}

// Запуск при загрузке страницы
document.addEventListener("DOMContentLoaded", getPatients);
