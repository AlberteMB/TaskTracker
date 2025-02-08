# Notes
## Task Tracker

### Task Model

| Name | Type | Description |
|  | --- | --- |
| id | String | Unique identifier for the task |
| description | String | Description of the task |
| status | Status | Status of the task |
| createdAt | Date | Due date of the task |
| updatedAt | Date | Last updated date of the task |

### Status Model

| Name | Type | Description |
| --- | --- | --- |
| TODO | String | Task is not completed |
| IN_PROGRESS | String | Task is in progress |
| DONE | String | Task is completed |
 

### Task Controller

| Name        | Type | Description |
|-------------| --- | --- |
| createTask  | Function | Creates a new task |
| updateTask  | Function | Updates an existing task |
| deleteTask  | Function | Deletes an existing task |
| getAllTasks | Function | Returns all tasks |
| getTaskTodo | Function | Returns all tasks with status TODO |
| getTaskInProgress | Function | Returns all tasks with status IN_PROGRESS |
| getTaskDone | Function | Returns all tasks with status DONE |

### Task Storage


### Task View



