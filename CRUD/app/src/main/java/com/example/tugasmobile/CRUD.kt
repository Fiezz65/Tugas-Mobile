package com.example.tugasmobile

data class DataKeyValue(val key: String, val value: String)

class Student(val id: String, inputName: String) {
    var name: String? = inputName
        get() {
            return field ?: "Tanpa Nama"
        }
        set(value) {
            if (value != null && value.length > 0) {
                field = value
            }
            else field = "Tanpa Nama"
        }

    init {
        this.name = inputName
    }
}

fun addData(list: ArrayList<Student>) {
    print("NIM: ")
    val id = readln()
    var exists = false
    for (student in list) {
        if (student.id == id) {
            exists = true
            break
        }
    }
    if (exists) {
        println("NIM sudah terdaftar!")
    } else {
        print("Nama: ")
        list.add(Student(id, readln()))
        println("Data ditambahkan")
    }
}

fun showData(list: ArrayList<Student>) {
    if (list.isEmpty()) {
        println("Data kosong")
    } else {
        for (i in 0 until list.size) {
            println("${i + 1}. ${list[i].id} - ${list[i].name}")
        }
    }
}

fun editData(list: ArrayList<Student>) {
    print("Cari NIM: ")
    val search = readln()
    var found = false
    for (student in list) {
        if (student.id == search) {
            print("Nama Baru: ")
            student.name = readln()
            println("Data diperbarui")
            found = true
            break
        }
    }
    if (!found) {
        println("NIM tidak ditemukan!")
    }
}

fun deleteData(list: ArrayList<Student>) {
    print("Hapus NIM: ")
    val delete = readln()
    var found = false
    for (student in list) {
        if (student.id == delete) {
            list.remove(student)
            println("Data dihapus")
            found = true
            break
        }
    }
    if (!found) {
        println("NIM tidak ditemukan!")
    }
}

fun showDataKeyValue(list: ArrayList<Student>) {
    val keyValueList = ArrayList<DataKeyValue>()
    for (student in list) {
        val name = student.name
        if (name != null) {
            keyValueList.add(DataKeyValue(student.id, name))
        }
    }
    if (keyValueList.isEmpty()) {
        println("Data kosong")
    } else {
        for (keyValue in keyValueList) {
            println("Key: ${keyValue.key}, Value: ${keyValue.value}")
        }
    }
}

fun main() {
    val list = ArrayList<Student>()
    var running = true

    while (running) {
        println("\n=== DATA MAHASISWA ===")
        println("1. Tambah Data")
        println("2. List Data")
        println("3. Edit Data")
        println("4. Hapus Data")
        println("5. Show Data")
        println("6. Keluar")
        print("Pilih menu: ")

        when (readln()) {
            "1" -> addData(list)
            "2" -> showData(list)
            "3" -> editData(list)
            "4" -> deleteData(list)
            "5" -> showDataKeyValue(list)
            "6" -> running = false
            else -> println("Pilihan tidak ada di menu!")
        }
    }
}