package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface ItemDao {

    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>

    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    // Specify the conflict strategy as IGNORE, when the user tries to add an
    // existing Item into the database Room ignores the conflict.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)
}
/**
 * 1. Mendeklarasikan antarmuka `ItemDao` sebagai Data Access Object (DAO)
 *    untuk mengelola operasi database terkait `Item`.
 * 2. Menggunakan anotasi `@Insert` untuk menambahkan item baru dengan strategi
 *    konflik `IGNORE` jika item sudah ada.
 * 3. Menggunakan anotasi `@Update` untuk memperbarui informasi item yang sudah ada.
 * 4. Menggunakan anotasi `@Delete` untuk menghapus item dari database.
 * 5. Mendefinisikan `@Query` untuk mengambil data item berdasarkan `id`
 *    dan seluruh item yang diurutkan berdasarkan `name`.
 */
