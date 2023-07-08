import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import {Dropdown} from 'primereact/dropdown';
import {TabView, TabPanel} from 'primereact/tabview';
import {DataTable} from 'primereact/datatable';
import {Dialog} from 'primereact/dialog';
import {InputNumber, InputNumberChangeEvent} from 'primereact/inputnumber';
import {InputText} from 'primereact/inputtext';
import {classNames} from 'primereact/utils';
import { InputTextarea } from 'primereact/inputtextarea';
import {AxiosResponse} from 'axios';
import React, {useEffect, useState} from 'react';
import {Calendar, CalendarChangeEvent} from 'primereact/calendar';
import { format } from 'date-fns';
import { InputSwitch } from "primereact/inputswitch";
import {MultiSelect} from "primereact/multiselect";
import  {DoseDto}  from '/pages/controller/model/Dose.model';

const View = ({visible,onClose,selectedItem}) => {

    const emptyItem = new DoseDto();
    const [item, setItem] = useState<DoseDto>(emptyItem);
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);

    useEffect(() => {
        setItem(selectedItem ? { ...selectedItem } : { ...emptyItem });
    }, [selectedItem]);

    const onTabChange = (e: { index: number }) => {
        setActiveIndex(e.index);
    };

    const hideDialog = () => {
        setSubmitted(false);
        onClose();
    };

    const itemDialogFooter = ( <>
        <Button label="Cancel" icon="pi pi-times" text onClick={hideDialog} /> < />
    );

return(
<Dialog visible={visible} style={{width: '70vw'}} header="Dose Details" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
<TabView activeIndex={activeIndex} onTabChange={onTabChange}>
<TabPanel header="Dose">
    <div className="formgrid grid">

                <div className="field col-6">
                    <label htmlFor="rendezVous">RendezVous</label>
                    <Dropdown  id="rendezVousDropdown"  value={selectedItem?.rendezVous?.id}  disabled  />
                </div>
                <div className="field col-6">
                    <label htmlFor="etatDose">EtatDose</label>
                    <Dropdown  id="etatDoseDropdown"  value={selectedItem?.etatDose?.libelle}  disabled  />
                </div>
        <div className="field col-6">
            <label htmlFor="dateDebutPrevu">DateDebutPrevu</label>
            <Calendar id="dateDebutPrevu" value={selectedItem?.dateDebutPrevu} disabled dateFormat="dd/mm/yy" showTime />
        </div>

        <div className="field col-6">
            <label htmlFor="dateDebutEffectif">DateDebutEffectif</label>
            <Calendar id="dateDebutEffectif" value={selectedItem?.dateDebutEffectif} disabled dateFormat="dd/mm/yy" showTime />
        </div>

            <div className="field col-6">
                <label htmlFor="description">Description</label>
                <span className="p-float-label">
                   <InputTextarea id="description" value={selectedItem?.description} disabled rows={5} cols={30} />
                </span>
            </div>

        </div>
</TabPanel>
</TabView>
</Dialog>
);
};
export default View;