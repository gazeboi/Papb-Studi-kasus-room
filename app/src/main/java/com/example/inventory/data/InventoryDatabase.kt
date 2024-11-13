package com.example.inventory.data
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var Instance: InventoryDatabase? = null

        fun getDatabase(context: Context): InventoryDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}



/**
 * InventoryDatabase adalah kelas abstrak yang mewakili database Room untuk aplikasi inventaris. Kelas
 * ini memiliki fungsi abstrak itemDao() yang memberikan akses ke ItemDao untuk menjalankan operasi CRUD.
 * Dalam companion object, ada properti Instance yang volatile untuk menyimpans satu instance database,
 * memastikan hanya ada satu instance di seluruh aplikasi. Metode getDatabase() mengembalikan instance
 * database yang ada atau membuat instance baru dengan Room.databaseBuilder.
 *//