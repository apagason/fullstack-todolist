import { configureStore } from "@reduxjs/toolkit";
import logger from "redux-logger";
import promise from "redux-promise";
import todoReducer from "./reducers/todoReducer";
import updateReducer from "./reducers/updateReducer";
import promiseMiddleware from "redux-promise-middleware";
import thunk from "redux-thunk";

export const store = configureStore({
  reducer: {
    todos: todoReducer,
    update: updateReducer,
  },
  middleware: [thunk, promiseMiddleware, promise, logger],
});
