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
import  {PatientDto}  from '/pages/controller/model/Patient.model';

const View = ({visible,onClose,selectedItem}) => {

    const emptyItem = new PatientDto();
    const [item, setItem] = useState<PatientDto>(emptyItem);
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
<Dialog visible={visible} style={{width: '70vw'}} header="Patient Details" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
<TabView activeIndex={activeIndex} onTabChange={onTabChange}>
<TabPanel header="Patient">
    <div className="formgrid grid">

            <div className="field col-6">
                <label htmlFor="ipp">Ipp</label>
                <InputText id="ipp" value={selectedItem?.ipp} disabled   />
            </div>

            <div className="field col-6">
                <label htmlFor="email">Email</label>
                <InputText id="email" value={selectedItem?.email} disabled   />
            </div>

            <div className="field col-6">
                <label htmlFor="cin">Cin</label>
                <InputText id="cin" value={selectedItem?.cin} disabled   />
            </div>

            <div className="field col-6">
                <label htmlFor="nom">Nom</label>
                <InputText id="nom" value={selectedItem?.nom} disabled   />
            </div>

            <div className="field col-6">
                <label htmlFor="prenom">Prenom</label>
                <InputText id="prenom" value={selectedItem?.prenom} disabled   />
            </div>

                <div className="field col-6">
                    <label htmlFor="age">Age</label>
                    <InputNumber id="age" value={item.age} disabled/>
                </div>

                <div className="field col-6">
                    <label htmlFor="ville">Ville</label>
                    <Dropdown  id="villeDropdown"  value={selectedItem?.ville?.libelle}  disabled  />
                </div>
                <div className="field col-6">
                    <label htmlFor="gender">Gender</label>
                    <Dropdown  id="genderDropdown"  value={selectedItem?.gender?.libelle}  disabled  />
                </div>
        </div>
</TabPanel>
</TabView>
</Dialog>
);
};
export default View;