import React from 'react';

type T = string | number;

interface FilterSectionProps {
  title: string;
  items: T[];
  selectedItems: T[];
  onItemClick: (item: T) => void;
}


export const FilterSection: React.FC<FilterSectionProps> = ({ title, items, selectedItems, onItemClick }) => {
  return (
    <div className="flex flex-col">
      <h1 className="text-xl">{title}</h1>
      <div className="flex flex-col max-h-64 overflow-y-auto border p-1 rounded-md mt-1">
        {items.map((item) => (
          <button
            key={String(item)} // Convertir en string pour la key au cas où c'est un nombre
            className={`p-1 cursor-pointer text-left text-m transition-colors rounded my-0.5
              ${selectedItems.includes(item)
                ? 'bg-blue-500 text-white'
                : 'hover:bg-blue-100'
              }
            `}
            onClick={() => onItemClick(item)}
          >
            {String(item)}
          </button>
        ))}
      </div>
    </div>
  );
};