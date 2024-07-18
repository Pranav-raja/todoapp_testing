const inputBox = document.getElementById("input-box");
const dueDateInput = document.getElementById("due-date");

function addTask() {
  if (inputBox.value === "" || dueDateInput.value === "") {
    alert("You must write something and select a date!");
    return;
  }
  
  const taskText = inputBox.value;
  const dueDate = new Date(dueDateInput.value);
  const dayOfWeek = dueDate.toLocaleDateString("en-US", { weekday: 'long' }).toLowerCase();
  
  const taskList = document.getElementById(`${dayOfWeek}-tasks`);
  
  let li = document.createElement("li");
  li.innerHTML = `${taskText} <span onclick="removeTask(this)">&#x2716;</span>`;
  taskList.appendChild(li);
  
  inputBox.value = "";
  dueDateInput.value = "";
  saveData();
}

function removeTask(element) {
  element.parentElement.remove();
  saveData();
}

function saveData() {
  const weekData = {
    monday: document.getElementById("monday-tasks").innerHTML,
    tuesday: document.getElementById("tuesday-tasks").innerHTML,
    wednesday: document.getElementById("wednesday-tasks").innerHTML,
    thursday: document.getElementById("thursday-tasks").innerHTML,
    friday: document.getElementById("friday-tasks").innerHTML,
    saturday: document.getElementById("saturday-tasks").innerHTML,
    sunday: document.getElementById("sunday-tasks").innerHTML,
  };
  localStorage.setItem("weekData", JSON.stringify(weekData));
}

function loadData() {
  const weekData = JSON.parse(localStorage.getItem("weekData"));
  if (weekData) {
    document.getElementById("monday-tasks").innerHTML = weekData.monday;
    document.getElementById("tuesday-tasks").innerHTML = weekData.tuesday;
    document.getElementById("wednesday-tasks").innerHTML = weekData.wednesday;
    document.getElementById("thursday-tasks").innerHTML = weekData.thursday;
    document.getElementById("friday-tasks").innerHTML = weekData.friday;
    document.getElementById("saturday-tasks").innerHTML = weekData.saturday;
    document.getElementById("sunday-tasks").innerHTML = weekData.sunday;
  }
}

loadData();