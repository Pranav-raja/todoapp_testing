// Initialize an object to store tasks
let tasks = {};

// Function to add a task to the tasks object
function addTask() {
  const inputBox = document.getElementById('input-box');
  const dueDate = document.getElementById('due-date').value;
  
  if (inputBox.value.trim() === '') {
    alert('Please enter a task description.');
    return;
  }

  if (dueDate === '') {
    alert('Please select a due date.');
    return;
  }

  const task = {
    description: inputBox.value.trim(),
    dueDate: dueDate
  };

  // Extract year and month from the dueDate
  const year = new Date(dueDate).getFullYear();
  const month = new Date(dueDate).getMonth(); // Month index (0-11)

  // Check if tasks[year] exists, if not, initialize it
  if (!tasks[year]) {
    tasks[year] = {};
  }

  // Check if tasks[year][month] exists, if not, initialize it
  if (!tasks[year][month]) {
    tasks[year][month] = [];
  }

  // Add the task to the corresponding month
  tasks[year][month].push(task);

  // Clear input fields
  inputBox.value = '';
  document.getElementById('due-date').value = '';

  // Update the calendar display
  updateCalendar(year, month);
}

function removeTask(element) {
    element.parentElement.remove();
    saveData();
  }

// Function to update the calendar display
function updateCalendar(year, month) {
  const calendarDiv = document.getElementById('calendar');
  calendarDiv.innerHTML = ''; // Clear previous calendar

  const monthName = new Date(year, month).toLocaleString('en-us', { month: 'long' });
  const yearHeader = `<h2>${monthName} ${year}</h2>`;
  calendarDiv.innerHTML += yearHeader;

  const daysInMonth = new Date(year, month + 1, 0).getDate(); // Number of days in the month
  const firstDay = new Date(year, month, 1).getDay(); // Day of the week of the first day (0-6, 0=Sunday)

  for (let day = 1; day <= daysInMonth; day++) {
    const dayDiv = document.createElement('div');
    dayDiv.classList.add('day');
    dayDiv.innerHTML = `<h3> ${monthName} ${day}, ${year}</h3><ul id="tasks-${year}-${month}-${day}"></ul>`;
    calendarDiv.appendChild(dayDiv);

    // Add tasks for this day
    if (tasks[year] && tasks[year][month]) {
      tasks[year][month].forEach(task => {
        const taskDueDate = new Date(task.dueDate);
        if (taskDueDate.getDate() === day) {
          const taskList = document.getElementById(`tasks-${year}-${month}-${day}`);
          const taskItem = document.createElement('li');
          taskItem.textContent = task.description;
          const removebutton = document.createElement("button");
          removebutton.textContent = "remove";
          removebutton.addEventListener("click", function(){
            // taskItem.remove();
            taskList.remove(taskItem);
          })
          taskItem.appendChild(removebutton);
          taskList.appendChild(taskItem);
        }
      });
    }
  }
}

// let tasks = {};

// function addTask() {
//   console.log("task adding")
//   const inputBox = document.getElementById('input-box');
//   const dueDate = document.getElementById('due-date').value;

//   if (inputBox.value.trim() === '') {
//     alert('Please enter a task description.');
//     return;
//   }

//   if (dueDate === '') {
//     alert('Please select a due date.');
//     return;
//   }

//   const task = {
//     description: inputBox.value.trim(),
//     dueDate: dueDate
//   };

//   $.ajax({
//     type: "POST",
//     url: "save_task.php",
//     data: { description: task.description, dueDate: task.dueDate },
//     success: function(response) {
//       console.log(response);
//       const result = JSON.parse(response);
//       if (result.success) {
//         // Reload tasks from the database and update the calendar
//         loadTasks();
//       } else {
//         alert('Failed to save task.');
//       }
//     }
//   });

//   inputBox.value = '';
//   document.getElementById('due-date').value = '';
//   console.log("task added successfully")
// }

// function loadTasks() {
//   console.log("task loading...")
//   $.ajax({
//     type: "GET",
//     url: "load_tasks.php",
//     success: function(response) {
//       tasks = JSON.parse(response);
//       const currentDate = new Date();
//       updateCalendar(currentDate.getFullYear(), currentDate.getMonth());
//     }
//   });
//   console.log("task loaded successfully")
// }

// function updateCalendar(year, month) {
//   console.log("updating calender")
//   const calendarDiv = document.getElementById('calendar');
//   calendarDiv.innerHTML = ''; // Clear previous calendar

//   const monthName = new Date(year, month).toLocaleString('en-us', { month: 'long' });
//   const yearHeader = `<h2>${monthName} ${year}</h2>`;
//   calendarDiv.innerHTML += yearHeader;

//   const daysInMonth = new Date(year, month + 1, 0).getDate(); // Number of days in the month
//   const firstDay = new Date(year, month, 1).getDay(); // Day of the week of the first day (0-6, 0=Sunday)

//   for (let day = 1; day <= daysInMonth; day++) {
//     const dayDiv = document.createElement('div');
//     dayDiv.classList.add('day');
//     dayDiv.innerHTML = `<h3>${monthName} ${day}, ${year}</h3><ul id="tasks-${year}-${month}-${day}"></ul>`;
//     calendarDiv.appendChild(dayDiv);

//     // Add tasks for this day
//     if (tasks[year] && tasks[year][month]) {
//       tasks[year][month].forEach(task => {
//         const taskDueDate = new Date(task.dueDate);
//         if (taskDueDate.getDate() === day) {
//           const taskList = document.getElementById(`tasks-${year}-${month}-${day}`);
//           const taskItem = document.createElement('li');
//           taskItem.textContent = task.description;
//           const removeButton = document.createElement('button');
//           removeButton.textContent = 'remove';
//           removeButton.addEventListener('click', function() {
//             removeTask(task.id);
//           });
//           taskItem.appendChild(removeButton);
//           taskList.appendChild(taskItem);
//         }
//       });
//     }
//   }
//   console.log("calender updated successfully")
// }

// function removeTask(taskId) {
//   console.log("task removing....")
//   $.ajax({
//     type: "POST",
//     url: "remove_task.php",
//     data: { id: taskId },
//     success: function(response) {
//       const result = JSON.parse(response);
//       if (result.success) {
//         loadTasks();
//       } else {
//         alert('Failed to remove task.');
//       }
//     }
//   });
//   console.log("task removed successfully")
// }

// // Load tasks on page load
// $(document).ready(function() {
//   loadTasks();
// });
