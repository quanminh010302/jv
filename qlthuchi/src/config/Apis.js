import axios from "axios";

const SEVER_CONTEXT = "/QLThuChi";

export const endpoints = {
    "categories": `${SEVER_CONTEXT}/api/categories`,
    "expenses": `${SEVER_CONTEXT}/api/expenses`,
    "type": `${SEVER_CONTEXT}/api/type`
}
export default axios.create({
    baseURL: "http://localhost:8080"
})