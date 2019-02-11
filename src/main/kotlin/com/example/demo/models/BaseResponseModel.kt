package com.example.demo.models

import com.example.demo.utils.Constants.STATUS_SUCCESS_MESSAGE
import com.example.demo.utils.Constants.STATUS_SUCCESS

data class BaseResponseModel(val status: Int = STATUS_SUCCESS, val message: String = STATUS_SUCCESS_MESSAGE, var responseModel: Any?)