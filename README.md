# ToDo WebApp testing
 <p>This is a simple project to manage tasks using HTML, CSS, JS, PHP and MySQL.</p>

        <h2>Table of Contents</h2>
        <ul>
            <li><a href="#installation">Installation</a></li>
            <li><a href="#usage">Usage</a></li>
        </ul>

        <h2 id="installation">Installation</h2>
        <p>To get a local copy up and running, follow these simple steps:</p>

        <h3>Prerequisites</h3>
        <ul>
            <li>PHP >= 7.0</li>
            <li>MySQL</li>
            <li>Web server (e.g.,XAMPP, Apache, Nginx)</li>
        </ul>

        <h3>Clone the Repo</h3>
        <pre><code>git clone https://github.com/Pranav-raja/todoapp_testing.git</code></pre>

        <h3>Database Setup</h3>
        <ol>
            <li>Create a database named <code>todoapp</code>.</li>
            <li>Import the following SQL to create the <code>users</code> table:
                <pre><code>
CREATE TABLE tasks (
    user_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE
);
                </code></pre>
            </li>
             <li>Import the following SQL to insert the rows into <code>users</code> table:
                <pre><code>
insertDataSQL = "INSERT INTO users (name, password, email) VALUES
('admin', '".md5('admin')."', 'alice@example.com'),
('bob', '".md5('bob')."', 'bob@example.com'),
('Charlie', '".md5('pass')."', 'charlie@example.com'),
('David', '".md5('password')."', 'david@example.com'),
('Eve', '".md5('password')."', 'eve@example.com')";

                </code></pre>
            </li>
            <li>Import the following SQL to create the <code>tasks</code> table:
                <pre><code>
CREATE TABLE tasks (
    task_id int AUTO_INCREMENT PRIMARY KEY,
    user_id int,
    task varchar(50),
    date date,
    dline date,
    category varchar(32)
);
                </code></pre>
            </li>
        </ol>

        <h2 id="usage">Usage</h2>
        <p>To run the project, follow these steps:</p>
        <ol>
            <li>Ensure your web server is running.</li>
            <li>Navigate to the project directory and open <code>index.php</code> in your browser.</li>
        </ol>
        <p>You should see a form to add tasks and a list of existing tasks.</p>

        <h2 id="contributing">Contributing</h2>
        <p>Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are <strong>greatly appreciated</strong>.</p>
        <p>If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".</p>
        <p>Don't forget to give the project a star! Thanks again!</p>
        <ol>
            <li>Fork the Project</li>
            <li>Create your Feature Branch (<code>git checkout -b feature/AmazingFeature</code>)</li>
            <li>Commit your Changes (<code>git commit -m 'Add some AmazingFeature'</code>)</li>
            <li>Push to the Branch (<code>git push origin feature/AmazingFeature</code>)</li>
            <li>Open a Pull Request</li>
        </ol>

        <h2>Contact</h2>
        <p>pranavraja - <a href="mailto:21i341@psgtech.ac.in">@mail</a></p>
        <p>Project Link: <a href="https://github.com/Pranav-raja/todoapp_testing">https://github.com/Pranav-raja/todoapp_testing</a></p>
    </div>
