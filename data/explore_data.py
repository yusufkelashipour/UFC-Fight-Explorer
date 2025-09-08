import pandas as pd
import os

#Load csv file
df = pd.read_csv("ufc-master.csv")

#Observe how many columns and rows their are
print("Dataset Shape", df.shape)
print("-----------------------")

#Display most recent fight
print("Most recent fight")
print(df.iloc[0])
print("-----------------------")

#Amount of fights per weight class
print("\nWeight classes in your data:")
print(df['WeightClass'].value_counts())
print("-----------------------")

#Dataset goes back to fights in 2010
print("Oldest fights in dataset")
print(df['Date'].tail(5))